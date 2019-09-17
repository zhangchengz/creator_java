package com.cubespace.relaying.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * 生成token工具类
 *
 * @author zhangc
 * @date 2019/9/10
 */
public class JwtUtil {

    /**
     * token过期时间为2小时
     */
    private static final long EXPIRE_TIME = 10 * 60 * 1000;

    /**
     * 密钥
     */
    private static final String SECRET = "cubespace";

    /**
     * 校验token是否正确
     *
     * @return 是否正确
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (SignatureVerificationException e) {
            return false;
        } catch (TokenExpiredException expiredException) {
            return false;
        }
    }

    /**
     * 获得token中的信息,无需secret解密也能获得
     *
     * @return 用户accountId
     */
    public static String getAccountId(String token) {

        JWTVerifier build = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = null;
        try {
            jwt = build.verify(token);
            return jwt.getClaims().get("accountId").asString();
        } catch (Exception e) {
            return "过期";
        }
    }


    /**
     * 生成签名,5小时后过期
     *
     * @return 加密的token
     */
    public static String sign(String accountId) {

        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        // 附带username信息
        return JWT.create()
                .withClaim("accountId", accountId)
                .withExpiresAt(date)
                .sign(algorithm);
    }

}
