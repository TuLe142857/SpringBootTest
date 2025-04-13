package edu.ptithcm.AuthTest.controller;

import com.nimbusds.jose.JOSEException;
import edu.ptithcm.AuthTest.sercurity.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import edu.ptithcm.AuthTest.model.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestLogin{
        private String username;
        private String password;
    }

    /**
     * FE send request to get token
     * @param request
     * @return
     */
    @GetMapping("/token")
    public Map<String, Object> login(@RequestBody RequestLogin request){
        System.out.println(request);
        boolean check = false;
        String token = null;
        for (Account acc: AccountSample.accounts){
            if((acc.getUserName().compareTo(request.getUsername()) == 0) &&
                    acc.getPassword().compareTo(request.getPassword()) == 0
            ){
                try{
                    token = JwtUtil.generateToken(acc.getUserName(), acc.getRole().name());
                } catch (JOSEException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }

        Map<String, Object> response = new HashMap<>();
        response.put("status", check);
        response.put("token", token);
        response.put("request", request);
        return response;
    }
}
