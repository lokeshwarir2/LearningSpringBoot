package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Review;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			//findInsturctorWithCourse(appDAO);};
			//findCourseForInstructor(appDAO);};
			//findCourseForInstructorBYJoinFetch(appDAO);};
			//updateInstructor(appDAO);};
			//updateCourse(appDAO);};
			//deleteCourseById(appDAO);};
			//createCourseAndReviews(appDAO);};
			//retrieveCourseAndReviews(appDAO);};
			deleteCourseAndReviews(appDAO);};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId=10;
		appDAO.deleteCourseById(theId);
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId=10;
		Course tempCourse=appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course tempCourse=new Course("java");
		tempCourse.add(new Review("good course"));
		tempCourse.add(new Review("bad "));
		tempCourse.add(new Review("vicky you are very good"));
		appDAO.saveReview(tempCourse);
		System.out.println(tempCourse.getReviews());
	}

	private void deleteCourseById(AppDAO appDAO){
		int theId=10;
		appDAO.deleteCourseById(theId);
	}
	private void updateCourse(AppDAO appDAO){
		int theId=10;
		Course tempCourse=appDAO.findCourseById(theId);
		tempCourse.setTitle("Vicky is a idiot");
		appDAO.updateCourse(tempCourse);
	}

	private void updateInstructor(AppDAO appDAO){
		int theId=1;
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		tempInstructor.setLastName("idiot");
		appDAO.updateInstructor(tempInstructor);
	}
	private void findCourseForInstructorBYJoinFetch(AppDAO appDAO) {
		int theId=1;
		Instructor tempInstructor=appDAO.findCourseByInstructorIdJoinFetch(theId);
		System.out.println(tempInstructor);
		System.out.println("the associated course is"+tempInstructor.getCourses());
	}

	private void findCourseForInstructor(AppDAO appDAO) {
		int theId=1;
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		List<Course> courses=appDAO.findCourseByInstructorId(theId);
		tempInstructor.setCourses(courses);
		System.out.println(tempInstructor.getCourses());
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
		System.out.println("deleting the instructor");
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


