package com.luv2code.springboot.thymeleafDemo.controller;

import com.luv2code.springboot.thymeleafDemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @RequestMapping("/showStudentForm")
    public String showForm(Model theModel){
        theModel.addAttribute("student",new Student());
        return "student-form";
    }
    @RequestMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        System.out.println("the Student:"+ theStudent.getFirstName()+" "+theStudent.getLastName());
        return "student-confirmation";
    }
}
