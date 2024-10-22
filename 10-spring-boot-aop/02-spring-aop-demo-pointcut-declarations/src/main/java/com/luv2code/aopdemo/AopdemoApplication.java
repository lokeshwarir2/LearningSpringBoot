package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDao, MembershipDAO theMembershipDao){
		return runner->{
			//demoTheBeforeAdvice(theAccountDao,theMembershipDao);};
			//demoTheAfterReturningAdvice(theAccountDao);};
			demoTheAfterThrowingAdvice(theAccountDao);};
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDao) {
		List<Account> theAccounts=theAccountDao.findAccount();
		System.out.println(theAccounts+"in main");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDao) {
		List<Account> theAccounts=null;
		try {
			boolean tripWire=true;
			theAccounts=theAccountDao.findAccount(tripWire);
		}
		catch (Exception exc){
			System.out.println("main program caught expression"+exc);
		}
		System.out.println(theAccounts+"in main");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDao,MembershipDAO theMembershipDAO) {
		theMembershipDAO.addSillyMethod();
		theAccountDao.addAccount();
		theAccountDao.setName("loki");
		theAccountDao.setCode("123");
		theAccountDao.getCode();
		theAccountDao.getName();
	}
}
