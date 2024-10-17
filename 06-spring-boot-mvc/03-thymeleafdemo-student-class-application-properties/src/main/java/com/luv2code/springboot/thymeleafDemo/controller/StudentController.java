package com.luv2code.springboot.thymeleafDemo.controller;

import com.luv2code.springboot.thymeleafDemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${favoriteLanguage}")
    private List<String> favoriteLanguage;

    @RequestMapping("/showStudentForm")
    public String showForm(Model theModel){
        theModel.addAttribute("student",new Student());
        theModel.addAttribute("countries",countries);
        theModel.addAttribute("favoriteLanguage",favoriteLanguage);
        return "student-form";
    }
    @RequestMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        System.out.println("the Student:"+ theStudent.getFirstName()+" "+theStudent.getLastName());
        return "student-confirmation";
    }
}
