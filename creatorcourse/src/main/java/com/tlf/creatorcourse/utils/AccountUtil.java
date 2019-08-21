package com.tlf.creatorcourse.utils;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AccountUtil {

    public String getAccountId(HttpServletRequest request){
        String token = request.getHeader("token");
        String accountId = JWTUtil.getAccountId(token);
        return accountId;
    }
}
