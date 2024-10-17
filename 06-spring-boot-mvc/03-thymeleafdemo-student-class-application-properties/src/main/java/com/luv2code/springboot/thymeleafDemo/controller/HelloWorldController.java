package com.luv2code.springboot.thymeleafDemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class HelloWorldController {
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloWorld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloWorld";
    }


    @RequestMapping(path="/processFormVersionTwo",method = RequestMethod.GET)
    public String letShoutDude(@RequestParam("studentName") String theName, Model model)
    {

        theName=theName.toUpperCase();
        String result="YO!! "+theName;
        model.addAttribute("message",result);
        return "helloWorld1";
    }
}
