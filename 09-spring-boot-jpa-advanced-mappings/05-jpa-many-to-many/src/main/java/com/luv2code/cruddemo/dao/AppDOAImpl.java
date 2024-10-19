package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDOAImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDOAImpl(EntityManager theentityManager){
        this.entityManager=theentityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {

        return entityManager.find(Instructor.class,theId);
    }

    @Transactional
    @Override
    public void delete(int theId) {
        Instructor theInstructor=entityManager.find(Instructor.class,theId);
        List<Course> courses=theInstructor.getCourses();
        for(Course c:courses){
            c.setInstructor(null);
        }
        entityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailsById(int theId) {

        return entityManager.find(InstructorDetail.class,theId);
    }

    @Override
    public void deleteInstructorDetailsById(int theId) {
        InstructorDetail ins=entityManager.find(InstructorDetail.class,theId);
        entityManager.remove(ins);
    }

    @Override
    public List<Course> findCourseByInstructorId(int theId) {
        TypedQuery<Course> query=entityManager.createQuery("from Course where instructor.id=:data",Course.class);
        query.setParameter("data",theId);
        List<Course> courses=query.getResultList();
        return courses;
    }

    @Override
    public Instructor findCourseByInstructorIdJoinFetch(int theId) {
        TypedQuery<Instructor> query=entityManager.createQuery("select i from Instructor i "+"JOIN FETCH i.courses"+" where i.id=:data",Instructor.class);
        query.setParameter("data",theId);
        Instructor instructor=query.getSingleResult();
        return instructor;
    }
    @Transactional
    @Override
    public void updateInstructor(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }
    @Transactional
    @Override
    public void updateCourse(Course temCourse) {
        entityManager.merge(temCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class,theId);
    }

    @Transactional
    @Override
    public void deleteCourseById(int theId) {
        Course c=entityManager.find(Course.class,theId);
        entityManager.remove(c);
    }

    @Transactional
    @Override
    public void saveReview(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        TypedQuery<Course> query=entityManager.createQuery(
                "select c from Course c JOIN FETCH c.reviews where c.id=:data",Course.class
        );
        query.setParameter("data",theId);
        Course c=query.getSingleResult();
        return c;
    }

    @Transactional
    @Override
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndStudentByCourseId(int theId) {
        TypedQuery<Course> query=entityManager.createQuery(
                "select c from Course c JOIN FETCH c.students where c.id=:data",Course.class
        );
        query.setParameter("data",theId);
        Course course=query.getSingleResult();
        return course;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {
        TypedQuery<Student> query=entityManager.createQuery(
                "select c from Student c JOIN FETCH c.courses where c.id=:data",Student.class
        );
        query.setParameter("data",theId);
        Student student=query.getSingleResult();
        return student;
    }

    @Override
    @Transactional
    public void update(Student tempStudent) {
        entityManager.merge(tempStudent);
    }

    @Transactional
    @Override
    public void deleteStudentById(int theId) {
        Student s=entityManager.find(Student.class,theId);
        entityManager.remove(s);
    }
}
