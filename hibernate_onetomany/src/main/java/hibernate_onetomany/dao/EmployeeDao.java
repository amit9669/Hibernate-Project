package hibernate_onetomany.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_onetomany.dto.Company;
import hibernate_onetomany.dto.Employee;

public class EmployeeDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void findEmployee(int id)
	{
		Employee employee = entityManager.find(Employee.class, id) ;
		
		if(employee!=null)
		{
			System.out.println(employee);
		}
		else
		{
			System.out.println("Employee not available");
		}
	}
	
	public void removeEmployee(int id)
	{
      Employee employee = entityManager.find(Employee.class, id) ;
		if(employee!=null)
		{
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
		}
	}
}
