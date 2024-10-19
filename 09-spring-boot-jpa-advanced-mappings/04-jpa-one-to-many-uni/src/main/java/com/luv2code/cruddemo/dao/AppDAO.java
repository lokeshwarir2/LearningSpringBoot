package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void delete(int theId);
    InstructorDetail findInstructorDetailsById(int theId);
    void deleteInstructorDetailsById(int theId);
    List<Course> findCourseByInstructorId(int theId);
    Instructor findCourseByInstructorIdJoinFetch(int theId);
    void updateInstructor(Instructor tempInstructor);
    void updateCourse(Course temCourse);
    Course findCourseById(int theId);
    void deleteCourseById(int theId);
    void saveReview(Course theCourse);
    Course findCourseAndReviewsByCourseId(int theId);
}
