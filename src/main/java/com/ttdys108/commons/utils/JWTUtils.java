package com.ttdys108.commons.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JWTUtils {

    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        String secret = "sdfkjsf";
        params.put("userId", "ty");
        String token = generate(secret, 10000, params);
        System.out.println(token);
        System.out.println(parse(secret, token));

    }

    public static String generate(String secret, Map<String, String> params) {
        return generate(secret, null, params);
    }

    public static String generate(String secret, Integer expires, Map<String, String> params) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTCreator.Builder builder = JWT.create();
        if(!CollectionUtils.isEmpty(params)) {
            params.forEach((key, val) -> { builder.withClaim(key, val);});
        }
        if(expires != null) {
            Date expiredDate = DateUtils.addMilliseconds(new Date(), expires);
            builder.withExpiresAt(expiredDate);
        }
        return builder.sign(algorithm);
    }

    public static boolean verfiy(String secret, String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm).build();
        try {
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            log.error("verfify token: {} failed", token, e);
            return false;
        }
    }

    /**
     * 解析token数据
     * @param secret secret
     * @param token jwt token
     * @return 如果token不合法，返回空map
     */
    public static Map<String, String> parse(String secret, String token) {
        Map<String, String> data = new HashMap<>();
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm).build();
        try {
            DecodedJWT decodedJWT = verifier.verify(token);
            Map<String, Claim> claims = decodedJWT.getClaims();
            if(!CollectionUtils.isEmpty(claims)) {
                claims.forEach((str, claim) -> {
                    data.put(str, claim.asString());
                });
            }
        } catch (JWTVerificationException e) {
            log.error("verfify token: {} failed", token, e);
        }
        return data;
    }

}
