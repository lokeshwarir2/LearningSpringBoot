package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        entityManager.remove(theInstructor);
    }
}
