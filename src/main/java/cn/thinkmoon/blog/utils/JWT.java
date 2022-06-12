package cn.thinkmoon.blog.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JWT {

    private JWT() {
    }

    // 从配置文件加载值
    private static String tokenSecret;

    private static int tokenExpire;

    private static String issuer;

    @Value("${token.secret}")
    public void setTokenSecret(String tokenSecret) {
        JWT.tokenSecret = tokenSecret;
    }

    @Value("${token.expire}")
    public void setTokenExpire(int tokenExpire) {
        JWT.tokenExpire = tokenExpire;
    }

    @Value("${token.issuer}")
    public void setIssuer(String issuer) {
        JWT.issuer = issuer;
    }

    /**
     * 生成Token
     *
     * @param id  String
     * @param map Map
     * @return token String
     */
    public static String generateToken(String id, Map<String, Object> map) {
        long now = System.currentTimeMillis();
        long ttl = now + (tokenExpire * 1000L);
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(map)
                .setId(id)
                .setIssuedAt(new Date())
                .setIssuer(issuer)
                .signWith(SignatureAlgorithm.HS256, tokenSecret);

        jwtBuilder.setExpiration(new Date(ttl));
        return jwtBuilder.compact();
    }

    public static String generateToken(Claims claims) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, tokenSecret);
        return jwtBuilder.compact();
    }

    /**
     * 解析Token
     *
     * @param token String
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(tokenSecret)
                .parseClaimsJws(token)
                .getBody();
    }

}