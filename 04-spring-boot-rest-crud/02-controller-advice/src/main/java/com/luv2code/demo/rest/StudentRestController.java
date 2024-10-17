package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudent;
    @PostConstruct
    public void loadData(){
       theStudent=new ArrayList<>();
        theStudent.add(new Student("Vicky","kumar"));
        theStudent.add(new Student("Loki","Reddy"));
    }
    @GetMapping("/Students")
    public List<Student> getStudents(){

        return theStudent;

    }
    //define endpoint i.e. return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //just index into the list
        if((studentId>=theStudent.size()||studentId<0)){
            throw new StudentNotFoundException("Student id is not "+studentId);
        }
        return theStudent.get(studentId);
    }


}
