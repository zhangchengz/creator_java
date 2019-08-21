package com.tlf.creatorconsumer.utils;

import com.tlf.creatorconsumer.req.BaseReq;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;

public class TokenUtil {

    public static HttpHeaders getRequestHeaders(HttpServletRequest request){
        HttpHeaders requestHeader = new HttpHeaders();
        String token = request.getHeader("Cube-Token");
        String header = request.getHeader("Cube-Domain");
        String role = JWTUtil.getRole(token);
        requestHeader.add("token", token);
        requestHeader.add("role",role);
        requestHeader.add("Cube-Domain",header);
        return requestHeader;
    }

    public static BaseReq getReq(HttpServletRequest request){
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        return new BaseReq(role,accountId);
    }

    public static HttpEntity<Object> getHttpEntity(HttpServletRequest request){
        HttpHeaders requestHeaders = getRequestHeaders(request);
        BaseReq baseReq = getReq(request);
        HttpEntity<Object> requestEntity = new HttpEntity<>(baseReq, requestHeaders);
        return requestEntity;
    }

}
