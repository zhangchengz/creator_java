package com.cubespace.relaying.controller;

import com.cubespace.relaying.common.Constants;
import com.cubespace.relaying.common.JsonResult;
import com.cubespace.relaying.po.UserPO;
import com.cubespace.relaying.vo.UserVO;
import com.cubespace.relaying.service.UserService;
import com.cubespace.relaying.utils.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;

/**
 * controller层
 *
 * @author zhangc
 * @date 2019/9/10
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    static ConcurrentHashMap<String,String> hashMap = new ConcurrentHashMap<>(60);

    @PostMapping(value = "login")
    public JsonResult login(@RequestBody UserPO userPo){
        if(StringUtils.isBlank(userPo.getNumber())||StringUtils.isBlank(userPo.getPassword())){
            return new JsonResult(Constants.CODE_FAIL,"请输入账号密码",null);
        }
        UserVO userVO = userService.login(userPo.getNumber(), userPo.getPassword(),Constants.ROLE_STUDENT);
        if(userVO ==null){
            return new JsonResult(Constants.CODE_AUTH,"账号或密码错误",null);
        }else{
            String token = userVO.getToken();
            String id = userVO.getId();
            hashMap.put(id,token);
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS", userVO);
        }
    }

    @PostMapping(value = "detection")
    public JsonResult detection(@RequestBody UserPO userPo){
        String id = userPo.getId();
        String token = userPo.getToken();
        if(StringUtils.isBlank(id)||StringUtils.isBlank(token)){
            return new JsonResult(Constants.CODE_FAIL,"id和token不能为空",null);
        }
        boolean verify = JwtUtil.verify(token);
        if(!verify){
            return new JsonResult(Constants.CODE_EXPIRED,"登录凭证已过期,请重新登录",null);
        }else{
            String userToken = hashMap.get(id);
            if(token.equals(userToken)){
                return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS", null);
            }else{
                return new JsonResult(Constants.CODE_OFFLINE,"账号在其他地方登录，您已下线，请重新登录" ,null);
            }
        }
    }


}
