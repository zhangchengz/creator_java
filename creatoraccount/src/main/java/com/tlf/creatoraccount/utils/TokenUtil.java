package com.tlf.creatoraccount.utils;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tlf.creatoraccount.constants.Constants;
import com.tlf.creatoraccount.exception.OperatingException;
import com.tlf.creatoraccount.exception.TokenErrorException;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TokenUtil {

    public static String getToken(HttpServletRequest request) throws TokenErrorException {
        String body = "";
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        body = stringBuilder.toString();
        JSONObject jsonObject = JSONUtil.parseObj(body);
        Object token1 = jsonObject.get("token");
        if(token1==null){
            throw new TokenErrorException(Constants.CODE_BAD, "token为空");
        }
        //获取token
        return token1.toString();
    }

    public static String getAccountId(HttpServletRequest request) throws OperatingException, TokenErrorException {
        String token = getToken(request);
        String accountId = JWTUtil.getAccountId(token);
        return accountId;
    }
}
