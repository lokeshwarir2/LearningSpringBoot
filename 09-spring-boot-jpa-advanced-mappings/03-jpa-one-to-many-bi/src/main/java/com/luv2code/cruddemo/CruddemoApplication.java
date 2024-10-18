package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{ //createInstructor(appDAO);};
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);};
			//findInstructorDetails(appDAO);};
			//deleteInstructorDetailById(appDAO);};
			//createInstructorWithCourses(appDAO);};
			findInsturctorWithCourse(appDAO);};
	}

	private void findInsturctorWithCourse(AppDAO appDAO) {
		int theId=1;
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println(tempInstructor+" "+tempInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor=new Instructor("Vicky","Kumar","vicky.com");
		InstructorDetail temInstructorDetail=new InstructorDetail(".com","some code");
		tempInstructor.setInstructorDetail(temInstructorDetail);
		Course temCourse1=new Course("spring");
		Course temCourse2=new Course("java");
		tempInstructor.add(temCourse1);
		tempInstructor.add(temCourse2);
		System.out.println("saving");
		appDAO.save(tempInstructor);

	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		int theId=3;
		appDAO.delete(theId);
	}

	private void findInstructorDetails(AppDAO appDAO) {
		int theId=2;
		InstructorDetail tem=appDAO.findInstructorDetailsById(theId);
		System.out.println(tem+" "+tem.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("deletign the instructor");
		appDAO.delete(theId);
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("the instructor is "+tempInstructor+" and the associated instructor details is "+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor=new Instructor("Vicky","Kumar","vicky.com");
		InstructorDetail temInstructorDetail=new InstructorDetail(".com","some code");
		tempInstructor.setInstructorDetail(temInstructorDetail);
		appDAO.save(tempInstructor);

	}
}


