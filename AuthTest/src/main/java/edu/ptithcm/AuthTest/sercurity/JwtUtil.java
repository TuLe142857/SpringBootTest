package edu.ptithcm.AuthTest.sercurity;


import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.*;
import com.nimbusds.jwt.*;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Date;

public class JwtUtil {
    public  static void main(String []args) throws  Exception{
        String token = generateToken("tu", "admin");

        JWTClaimsSet claim= validateToken(token);
        System.out.println(token);
        System.out.println("this token will exprired at:"+ claim.getExpirationTime());

        boolean check = claim.getExpirationTime().after(new Date());
        System.out.println("Check time valide: "+check);
        System.out.println(claim.getSubject());
        System.out.println(claim.getClaim("role"));
    }

    private static final String SECRET = "dkjfhg98734y5ksjdgf98275skjehf873w465"; // nên dài ít nhất 256 bit
    private static final int EXPIRED_TIME = 1000*60*60;

    public static String generateToken(String username, String role) throws JOSEException {
        JWTClaimsSet claims = new JWTClaimsSet.Builder()
                .subject(username)
                .claim("role", role)
                .issuer("demo-app")
                .expirationTime(new Date(new Date().getTime() + EXPIRED_TIME)) // 1 giờ
                .build();

        SignedJWT signedJWT = new SignedJWT(
                new JWSHeader(JWSAlgorithm.HS256),
                claims
        );

        signedJWT.sign(new MACSigner(SECRET));

        return signedJWT.serialize();
    }

    public static JWTClaimsSet validateToken(String token) throws Exception {
        SignedJWT signedJWT = SignedJWT.parse(token);
        boolean isValid = signedJWT.verify(new MACVerifier(SECRET));

        if (!isValid) throw new Exception("Invalid signature");

        Date exp = signedJWT.getJWTClaimsSet().getExpirationTime();
        if (exp.before(new Date())) throw new Exception("Token expired");

        return signedJWT.getJWTClaimsSet();
    }

    public static String getJwtTokenFromRequest(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token != null && token.substring(0, 7).compareTo("Bearer ") == 0){
            token = token.substring(7);
        }
        else{
            token = null;
        }
        return token;
    }
}
