package com.example.personalFinanceTracker.controller;

import com.example.personalFinanceTracker.Repo.UserRepository;
import com.example.personalFinanceTracker.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.dao.DataIntegrityViolationException;


import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/register")
    public String showRegisterPg(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }



   @PostMapping("/registerUser")
     public String registerUser(@Valid @ModelAttribute User user, BindingResult bindingResult,Model model,RedirectAttributes redirectAttributes) {
        Optional<User> existUser = (userRepository.findByUsername(user.getUsername()));
        if (existUser.isPresent()) {

           model.addAttribute("errorMessage", "Username already exists. Please choose another one.");
           return "register";


        } else {
            userRepository.save(user);
            return "redirect:/dashboard";
        }

    }


    @RequestMapping("/login")
    public String showLoginPg(Model model) {
        model.addAttribute("user", new User());
        return "login1";
    }


    @PostMapping("/loginUser")
    public String loginUser(@ModelAttribute User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login1";
        } else {
            // Find the user by email
            Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

            // Check if the user exists and the password matches
            if (existingUser.isPresent() && user.getPassword().equals(existingUser.get().getPassword())) {
                // If login is successful, redirect to the dashboard
                return "redirect:/dashboard";
            } else {
                // If login fails, add an error message and return to the login page
                model.addAttribute("loginError", "Invalid email or password");
                return "login1";
            }
        }
    }

}
