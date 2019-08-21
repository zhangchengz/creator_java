package com.icubespace.projects.gateway.filter;

import com.icubespace.projects.gateway.config.WhileUrlBean;
import com.icubespace.projects.gateway.service.RedisService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class TokenFilter extends ZuulFilter {

    protected static final Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    @Autowired
    private WhileUrlBean whileUrlBean;

    @Autowired
    private RedisService redisService;


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx= RequestContext.getCurrentContext();
        HttpServletRequest req=ctx.getRequest();
        String uri = req.getRequestURI().toString();

        String cubeToken = req.getHeader("Cube-Token");
        String domain = req.getHeader("Cube-Domain");
        String cubeRole = req.getHeader("Cube-Role");


//        logger.info("whileUrlBean:[{}]", whileUrlBean.getWhileUrls());
//        logger.info(req.toString());
        String ipAddr=this.getIpAddr(req);
        logger.info("IP：[{}], uri: [{}], token：[{}], domain：[{}], cubeRole: [{}]",ipAddr, uri, cubeToken, domain, cubeRole);

        if(StringUtils.isBlank(domain)){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(200);
            ctx.setResponseBody("{\"code\":-100,\"msg\":\"lose domain\"}");
            ctx.getResponse().setContentType("text/html;charset=UTF-8");
            return null;
        }
        //此处判断是否要拦截**************
        //过滤登录方法
        for (String whileUrl: whileUrlBean.getWhileUrls()) {
            if(uri.contains(whileUrl)){
                logger.info("uri:{},is Contain in while url.", uri);
                ctx.addZuulRequestHeader("domain", domain);
                ctx.addZuulRequestHeader("ipAddr", ipAddr);

                return null;
            }
        }
        Map<String, Object> valueMap = null;
        String tokenValue=null;
        if(StringUtils.isNotBlank(cubeToken)){
            //获取redis存储的token
//            tokenValue= redisService.get(cubeToken);
//            logger.info("redisService isExist：[{}]", tokenValue);
//            if (StringUtils.isNotBlank(tokenValue)){
//                //查询redis是否有token
//                redisService.expire(cubeToken, 7200);
//            }
            Long tokenExpire = redisService.getExpire(cubeToken);
            logger.info("tokenExpire value：[{}]", tokenExpire);
            if(tokenExpire > 0){

                valueMap = redisService.getMap(cubeToken);
                logger.info("redisService value：[{}]", valueMap);
                if (valueMap != null){
                    tokenValue = (String)valueMap.get("accountId");
                    redisService.expire(cubeToken, 7200);
                }
            }
        }
        //*******************开始拦截****************************
        logger.info("method: [{}], url: [{}]",req.getMethod(),uri);
        //没有加认证token 就没有访问权限
        if(StringUtils.isBlank(cubeToken) || tokenValue==null){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(200);
            ctx.setResponseBody("{\"code\":-99,\"msg\":\"token is empty or invalid, relogin！\"}");
            ctx.getResponse().setContentType("text/html;charset=UTF-8");
        }
        //*******************结束拦截****************************
        ctx.addZuulRequestHeader("tokenValue", tokenValue);
        ctx.addZuulRequestHeader("token", cubeToken);
        ctx.addZuulRequestHeader("ipAddr", ipAddr);
        ctx.addZuulRequestHeader("domain", domain);
        return null;
    }

    public  String getIpAddr(HttpServletRequest request){

        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
