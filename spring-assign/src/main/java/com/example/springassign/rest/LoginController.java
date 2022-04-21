package com.example.springassign.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showMyLoginPage(){
        // return "plain-login";
        return "redirect:/login";
    }

    // add request mapping for access denied
    @GetMapping("/access-denied")
    public String showAccessDenied(){
        // return "access-denied";
        return "access-denied";
    }





}
