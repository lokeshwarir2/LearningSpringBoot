package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void delete(int theId);
    InstructorDetail findInstructorDetailsById(int theId);
    void deleteInstructorDetailsById(int theId);
}
