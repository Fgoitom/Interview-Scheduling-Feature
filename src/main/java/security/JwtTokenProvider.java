package security;



import com.sun.security.auth.UserPrincipal;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import java.util.Date;

    @Component
    public class JwtTokenProvider {

        private final String jwtSecret = "yourSecretKey"; // Replace with your own secret key
        private final long jwtExpirationInMs = 86400000; // 24 hours

        public String generateToken(Authentication authentication) {
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            Date now = new Date();
            Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

            return Jwts.builder()
                    .setSubject(userPrincipal.getName())
                    .setIssuedAt(new Date())
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS512, jwtSecret)
                    .compact();
        }

        public String getUsernameFromToken(String token) {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getSubject();
        }

        public boolean validateToken(String token) {
            try {
                Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
                return true;
            } catch (SignatureException ex) {
                // Invalid JWT signature
            } catch (MalformedJwtException ex) {
                // Invalid JWT format
            } catch (ExpiredJwtException ex) {
                // Expired JWT
            } catch (UnsupportedJwtException ex) {
                // Unsupported JWT
            } catch (IllegalArgumentException ex) {
                // JWT claims string is empty
            }
            return false;
        }
    }


