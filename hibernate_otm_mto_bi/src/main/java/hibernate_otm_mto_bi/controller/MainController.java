package hibernate_otm_mto_bi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_otm_mto_bi.dto.Company;
import hibernate_otm_mto_bi.dto.Employee;

public class MainController 
{
	public static void main(String[] args) {
		Company company = new Company() ;
		
		company.setName("TCS");
		company.setGst("TCS123");
		Employee employee1 = new Employee();
		employee1.setName("Amit");
		employee1.setAddress("Pune");
		employee1.setPhone(9325303716l);
		employee1.setCompany(company);
		
		Employee employee2 = new Employee();
		employee2.setName("Amit");
		employee2.setAddress("Pune");
		employee2.setPhone(9325303716l);
		employee2.setCompany(company);
		
		Employee employee3 = new Employee();
		employee3.setName("Amit");
		employee3.setAddress("Pune");
		employee3.setPhone(9325303716l);
		employee3.setCompany(company);
		
		List <Employee> list = new ArrayList<Employee>();
		
		list.add(employee1);
		list.add(employee2);
		list.add(employee3);
		
		company.setEmployees(list);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
//		entityTransaction.begin();
//		entityManager.persist(company);
//		entityManager.persist(employee1);
//		entityManager.persist(employee2);
//		entityManager.persist(employee3);
//		entityTransaction.commit();
		
//		Employee employeee =entityManager.find(Employee.class, 1) ;
//		System.out.println(employeee);
		
		Company company2 = entityManager.find(Company.class, 1);
		System.out.println(company2);
  		
		
		
	}
}
