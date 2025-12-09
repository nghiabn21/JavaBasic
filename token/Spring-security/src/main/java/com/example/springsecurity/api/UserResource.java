package com.example.springsecurity.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springsecurity.domain.Email;
import com.example.springsecurity.domain.Role;
import com.example.springsecurity.domain.User;
import com.example.springsecurity.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Slf4j
public class UserResource {
    @Autowired
    UserService userService;
//    private JavaMailSender mailSender;

    @PostMapping("/forgot_password")
    public ResponseEntity<?> processForgotPassword(@RequestBody Email email, HttpServletRequest request) {
     //   String email = request.getParameter("a");
        log.info(email.getEmail().toString());
        String token = RandomStringUtils.random(30);
        String pass = RandomStringUtils.random(5);
//        try {
//            userService.updateResetPasswordToken(token, email.getEmail(), pass);
//            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
////            sendEmail(email.getEmail(), resetPasswordLink,pass);
//        } catch (CustomerNotFoundException | MessagingException | UnsupportedEncodingException ex) {
//            throw new CustomerNotFoundException("Error");
//        }
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login() {
      //  URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
  //      String name = login.getAccount() ;
        return ResponseEntity.ok("Login Success");
    }

    @PostMapping("/token/refresh")
    public ResponseEntity<?> refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(token);
                String username = decodedJWT.getSubject();
                User user = userService.getUser(username);
                 String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream()
                                .map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception e) {
                response.setHeader("Error", e.getMessage());
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                Map<String, String> errors = new HashMap<>();
                errors.put("Error Message", e.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), errors);

            }
        }else {
            throw new RuntimeException("Refresh token is missing");
        }
        return ResponseEntity.ok("Login Success");
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        // lây đường dẫn hiện tại + /api/user/save
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(  userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<?> saveRole(@RequestBody Role user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body( userService.saveRole(user));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addtouser(@RequestBody RoleToUser user) {
        userService.addRoleToUser(user.getUserName(), user.getRoleName());
        return ResponseEntity.ok().build();
    }

//    public void sendEmail(String recipientEmail, String link, String pass)
//            throws MessagingException, UnsupportedEncodingException {
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//        helper.setFrom("nghiabn21@gmail.com", "Shoppe Support");
//        helper.setTo(recipientEmail);
//        String subject = "Here's the link to reset your password";
//        String content = "<p>Hello,</p>"
//                + "<p>You have requested to reset your password.</p>"
//                + "<p>Click the link below to change your password:</p>"
//                + "<p><a href=\"" + link + "\">Change my password</a></p>"
//                + "<p>" + pass + "</p>"
//                + "<br>"
//                + "<p>Ignore this email if you do remember your password, "
//                + "or you have not made the request.</p>";
//        helper.setSubject(subject);
//        helper.setText(content, true);
//        mailSender.send(message);
//    }

    @GetMapping("/reset_password")
    public ResponseEntity<?> showResetPasswordForm(@Param(value = "token") String token) {
//        User customer = userService.getByResetPasswordToken(token);
//        if (customer == null) {
//            return ResponseEntity.ok("failed");
//        }
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/reset_password")
    public ResponseEntity<?> processResetPassword(HttpServletRequest request,@Param(value = "token") String token) {
        String tokens = request.getParameter("token");
        String password = request.getParameter("password");
//        User customer = userService.getByResetPasswordToken(tokens);
//        if (customer == null) {
//            return ResponseEntity.ok("failed");
//        }
//        User user = userService.getByResetPasswordToken(token);

//        if (user == null) {
//            return ResponseEntity.ok("failed");
//        } else {
//            userService.updatePassword(user, password);
//            return ResponseEntity.ok("ok");
//        }
        return ResponseEntity.ok("ok");
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class RoleToUser {
        private String userName;
        private String roleName;

    }
}

