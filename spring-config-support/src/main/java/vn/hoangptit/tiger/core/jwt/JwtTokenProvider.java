package vn.hoangptit.tiger.core.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Create file JwtTokenConfig
 *
 * @author duyhoangptit
 * @since 7/2/2019
 */
@Component
@Slf4j
public class JwtTokenProvider {

    /**
     * Khai báo đoạn JWT_SECRET_KEY là bí mật, chỉ phía server biết.
     */
    @Value("${spring.jwt.config.secret-key}")
    private String JWT_SECRET_KEY;

    /**
     * Thời gian hiệu lực của chuỗi jwt
     */
    private final long JWT_EXPIRATION = 604800000L;

    /**
     * Tạo ra jwt từ thông tin user
     *
     * @return
     */
    public String generateToken(Long userId) {
        DateTime now = new DateTime();
        DateTime expiryDate = new DateTime(now.getMillis() + JWT_EXPIRATION);

        // Tạo chuỗi json web token từ id của user.
        return Jwts.builder()
                .setSubject(Long.toString(userId))
                .setIssuedAt(now.toDate())
                .setExpiration(expiryDate.toDate())
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET_KEY)
                .compact();
    }


    /**
     * Lấy thông tin user từ jwt token
     *
     * @param token
     * @return
     */
    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    /**
     * validate token
     *
     * @param authToken
     * @return
     */
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET_KEY).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException me) {
            log.error("Invalid JWT token");
            throw me;
        } catch (ExpiredJwtException ee) {
            log.error("Expired JWT token");
            throw ee;
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
            throw ex;
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
            throw ex;
        }
    }

}
