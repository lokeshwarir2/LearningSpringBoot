package com.luv2code.demo.rest;

public class StudentNotFoundException extends RuntimeException{
   public StudentNotFoundException(String message){
       super(message);
   }
}
