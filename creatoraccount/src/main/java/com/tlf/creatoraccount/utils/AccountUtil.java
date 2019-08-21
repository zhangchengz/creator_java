package com.tlf.creatoraccount.utils;

import com.tlf.creatoraccount.exception.OperatingException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AccountUtil {

    public String getAccountId(HttpServletRequest request) throws OperatingException {
        String token = request.getHeader("token");
        String accountId = JWTUtil.getAccountId(token);
        return accountId;
    }
}
