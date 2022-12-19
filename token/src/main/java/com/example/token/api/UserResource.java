package com.example.token.api;

import com.example.token.domain.Login;
import com.example.token.domain.Role;
import com.example.token.domain.User;
import com.example.token.domain.Utility;
import com.example.token.exception.CustomerNotFoundException;
import com.example.token.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.List;
import java.util.Map;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserResource {
    @Autowired
    UserService userService;


    private JavaMailSender mailSender;


    @GetMapping("/users")
    public ResponseEntity<List<User>> getUser() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> roleUser(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addroleUser(@RequestBody RoleToUser role) {
        userService.addRoleToUser(role.getUserName(), role.getRoleName());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/forgot_password")
    public ResponseEntity<?> processForgotPassword(HttpServletRequest request) {
        String email = request.getParameter("email");
        String token = RandomString.make(30);
        try {
            userService.updateResetPasswordToken(token, email);
            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
            sendEmail(email, resetPasswordLink);
        } catch (CustomerNotFoundException | MessagingException | UnsupportedEncodingException ex) {
            throw new CustomerNotFoundException("Error");
        }
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
      //  URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
  //      String name = login.getAccount() ;
        return ResponseEntity.ok("pl");
    }

    public void sendEmail(String recipientEmail, String link)
            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("nghiabn21@gmail.com", "Shoppe Support");
        helper.setTo(recipientEmail);
        String subject = "Here's the link to reset your password";
        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }

    @GetMapping("/reset_password")
    public ResponseEntity<?> showResetPasswordForm(@Param(value = "token") String token) {
        User customer = userService.getByResetPasswordToken(token);
        if (customer == null) {
            return ResponseEntity.ok("failed");
        }
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/reset_password")
    public ResponseEntity<?> processResetPassword(HttpServletRequest request,@Param(value = "token") String token) {
        String tokens = request.getParameter("token");
        String password = request.getParameter("password");
        User customer = userService.getByResetPasswordToken(tokens);
        if (customer == null) {
            return ResponseEntity.ok("failed");
        }
        User user = userService.getByResetPasswordToken(token);

        if (user == null) {
            return ResponseEntity.ok("failed");
        } else {
            userService.updatePassword(user, password);
            return ResponseEntity.ok("ok");
        }
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class RoleToUser {
        private String userName;
        private String roleName;

    }
}

