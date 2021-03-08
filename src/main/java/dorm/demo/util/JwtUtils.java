package dorm.demo.util;

import  io.jsonwebtoken.*;

import java.util.Date;

/**
 * jwt工具类
 */
public class JwtUtils {

    private static String key = "xuyuanzeng";
    private static long ttl = 1000*60*60;//一个小时

    public static String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public static long getTtl() {
        return ttl;
    }
    public void setTtl(long ttl) {
        this.ttl = ttl;
    }
    /**
     * 生成JWT
     *
     * @param userId
     * @param subject
     * @return
     */
    public static String createJWT(String userId, String subject, String roles,String ipAddr) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder().setId(userId)
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, ipAddr+key).claim("roles",roles);
        if (ttl > 0) {
            builder.setExpiration( new Date( nowMillis + ttl));
        }
        return builder.compact();
    }
    /**
     * 解析JWT
     * @param jwtStr
     * @return
     */
    public static Claims parseJWT(String jwtStr, String ipAddr){
        return  Jwts.parser()
                .setSigningKey(ipAddr+key)
                .parseClaimsJws(jwtStr)
                .getBody();
    }

}
