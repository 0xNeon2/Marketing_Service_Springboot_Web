package com.example.marketingservice.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.marketingservice.model.User;
import com.example.marketingservice.repository.UserRepository;

@Controller
public class ProfileController {
    
    private UserRepository userRepository;

    public ProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName(); // Get the logged-in user's email
        User user = userRepository.findByEmail(email);
        model.addAttribute("user", user);
        return "profile";
    }
}
