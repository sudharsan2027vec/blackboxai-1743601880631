package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class DemoApplication {

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/signInUp")
    public String signInUp() {
        return "signInUp.html";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, 
                       @RequestParam String password,
                       UserService userService) {
        try {
            userService.authenticateUser(email, password);
            return "redirect:/?loginSuccess=true";
        } catch (RuntimeException e) {
            return "redirect:/signInUp?error=" + e.getMessage();
        }
    }

    @PostMapping("/register")
    public String register(@RequestParam String name,
                          @RequestParam String email,
                          @RequestParam String password,
                          UserService userService) {
        try {
            userService.registerUser(name, email, password);
            return "redirect:/signInUp?registerSuccess=true";
        } catch (RuntimeException e) {
            return "redirect:/signInUp?error=" + e.getMessage();
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
