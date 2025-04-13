package edu.ptithcm.AuthTest.sercurity;


import com.nimbusds.jwt.JWTClaimsSet;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = JwtUtil.getJwtTokenFromRequest(request);
        if(token !=  null)
            try{
                JWTClaimsSet claim =JwtUtil.validateToken(token);
                UserDetails userDetails
            }catch (Exception e){
                System.out.println("token is not valid");
            }
    }
}
