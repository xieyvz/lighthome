package com.xieyv.lighthome.common.util;

import com.xieyv.lighthome.common.exception.LhException;
import com.xieyv.lighthome.common.result.ResultCodeEnum;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 *  @author xieyv
 *  jwt相关方法
 */
public class JwtUtil {

    private static final long tokenExpiration = 60 * 60 * 1000L;

    private static final SecretKey secretKey = Keys.hmacShaKeyFor("xieyvazturmxieyvazturmxieyvazturm".getBytes(StandardCharsets.UTF_8));

    /**
     *   生成jwt token
     */
    public static String createJWT(Long uid, String username) {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .setSubject("LOGIN")
                .claim("uid", uid)
                .claim("username", username)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     *  解析jwt是否合法，并返回其中的内容
     */
    public static Claims parseJWT(String jwt) {
        if(jwt == null) {
            throw new LhException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
        }
        try{
            JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(secretKey).build();
            Jws<Claims> claimsJws = jwtParser.parseClaimsJws(jwt);//jws解析已签名的jwt
            return claimsJws.getBody();
        }
        catch (ExpiredJwtException eje){
            throw new LhException(ResultCodeEnum.TOKEN_EXPIRED); //token过期
        }
        catch (JwtException je){
            throw new LhException(ResultCodeEnum.TOKEN_INVALID); //token非法
        }
    }

    private JwtUtil(){};
}
