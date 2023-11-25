package com.example.Springboot_Project.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import com.example.Springboot_Project.model.index;
import com.example.Springboot_Project.service.User_serviceIMPL;

@RestController
@RequestMapping("/api")
public class First_Controller {
    @Autowired
    User_serviceIMPL service;
    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }
    @GetMapping("/register")
    public String registerform() {
        return "index";
    }

    @PostMapping("/register")
    public String registerFormSubmit(@ModelAttribute index user){
        service.addUser(user);
        return "home";
    }
    @GetMapping("/users")
    public String listUser(Model model){
        List<index> list=service.selectUser();
        model.addAttribute("users",list);
        return "userdata"; 
    }
    @GetMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int Id){
        service.deleteUser(Id);
        return "userdata";
    }
    @GetMapping("select/{Id}")
    public String selectById(@PathVariable int Id,Model model){
        index user=service.getUserById(Id);
        model.addAttribute("users", user);
        return "userdata";
    }
    @GetMapping("/forgotPassword")
    public String forgotPasswordForm() {
        return "forgot";
    }

    @PostMapping("/forgotPassword")
    public String updatePassword(@RequestParam("username") String username,@RequestParam("newPassword") String newPassword) {
         
        service.updatePassword(username, newPassword);

        return "passwordUpdated";
    }
}