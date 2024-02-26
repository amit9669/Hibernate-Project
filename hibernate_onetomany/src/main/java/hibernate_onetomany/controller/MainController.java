package hibernate_onetomany.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_onetomany.dao.CompanyDao;
import hibernate_onetomany.dao.EmployeeDao;
import hibernate_onetomany.dto.Company;
import hibernate_onetomany.dto.Employee;

public class MainController
{
	public static void main(String[] args) {

		CompanyDao dao = new CompanyDao();
		Employee e1 = new Employee();
		Company company = new Company();
		
		e1.setId(1);
		e1.setName("Amit");
		e1.setPhone(9325303716l);
		e1.setAddress("Islampur");
		
		Employee e2 = new Employee();
		e2.setId(2);
		e2.setName("Vishal");
		e2.setPhone(9876543210l);
		e2.setAddress("Kolhapur");
		
		Employee e3 = new Employee();
		e3.setId(3);
		e3.setName("Rushi");
		e3.setPhone(9123456789l);
		e3.setAddress("Latur");
		
		List<Employee> employees = new ArrayList<Employee>();	
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
			
		company.setId(101);
		company.setName("Infosys");
		company.setGst("Infosys123");
		company.setEmployees(employees);
		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		
//		entityTransaction.begin();
//		entityManager.persist(e1);
//		entityManager.persist(e2);
//		entityManager.persist(e3);
//		entityManager.persist(company);
//		entityTransaction.commit();
		
		dao.saveCompany(company);
		
//		dao.findCompany(101);
		
//		EmployeeDao e_dao = new EmployeeDao();	
//		e_dao.findEmployee(4);
		
//		dao.deleteCompany(101);
		
//		company.setName("Infosys");
//		company.setGst("Infosys123");
//		company.setEmployees(employees);
//		
//		dao.updateOnlyCompany(101, company);
		
//		dao.updateBoth(101, company);
		
//		dao.removeEmployee(101,1);
			
	}
}
