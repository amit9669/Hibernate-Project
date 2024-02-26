package hibernate_onetomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_onetomany.dto.Company;
import hibernate_onetomany.dto.Employee;

public class CompanyDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void saveCompany(Company company)
	{
//		List<Employee>  employees = company.getEmployees();
		
		entityTransaction.begin();
//		for(Employee employee : employees)
//		{
//			entityManager.persist(employee);
//		}
		entityManager.persist(company);
		entityTransaction.commit();
	}
	
	public void findCompany(int id)
	{
		Company company = entityManager.find(Company.class, id) ;
		
		if(company != null)
		{
			System.out.println(company);
		}
		else
		{
			System.out.println("Company is not available");
		}
	}
	
	public void deleteCompany(int id)
	{
		Company company = entityManager.find(Company.class, id) ;
		if(company!=null)
		{
//			List<Employee> employees = company.getEmployees();
			entityTransaction.begin();
//			for (Employee employee : employees) 
//			{
//				entityManager.remove(employee);
//			}
			entityManager.remove(company);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Company not available");
		}
	}
	 
	public void updateOnlyCompany(int id, Company company)
	{
		Company dbcompany = entityManager.find(Company.class, id) ;
		
		if(dbcompany!=null)
		{
			company.setId(id);
			company.setEmployees(dbcompany.getEmployees());
			
			entityTransaction.begin();
			entityManager.merge(company) ;
			entityTransaction.commit();	
		}
		else
		{
			System.out.println("ID not found!!!");
		}
	}
	
	public void updateBoth(int id, Company company)
	{
		Company dbCompany = entityManager.find(Company.class, id) ;
		
		if(dbCompany!=null)
		{
			company.setId(id);
		    List<Employee> dblist = company.getEmployees(); 
		    List<Employee> list = dbCompany.getEmployees(); 
		    
		    for (int i = 0; i < dblist.size(); i++)
		    {
			   	list.get(i).setId(dblist.get(i).getId());
			}	    
		    entityTransaction.begin();
			for (Employee employee : list) 
			{
				entityManager.merge(employee);
			}
			entityManager.merge(company);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("ID not available!!!!");
		}
	}
	
	public void removeEmployee(int c_id, int id)
	{
       Company company = entityManager.find(Company.class, c_id) ;
       Employee employee = entityManager.find(Employee.class, id) ;
       
       List<Employee> list = company.getEmployees();
       list.remove(employee) ;
       
       entityTransaction.begin();
       entityManager.remove(employee);
       entityManager.merge(company);
       entityTransaction.commit();	
	}
	
	public void removeMultipleEmployees(int cid, List<Integer> eids)
	{
		Company company = entityManager.find(Company.class, cid) ;
		List<Employee> list = new ArrayList<Employee>();
		for(Integer eid : eids)
		{
			Employee employee = entityManager.find(Employee.class, eid) ;
			list.add(employee);
		}
		
		List<Employee> employees = company.getEmployees();
		employees.removeAll(employees);
		
		entityTransaction.begin();
		for(Employee employee : list)
		{
			entityManager.remove(employee);
		}
		entityTransaction.commit();
	}
}
