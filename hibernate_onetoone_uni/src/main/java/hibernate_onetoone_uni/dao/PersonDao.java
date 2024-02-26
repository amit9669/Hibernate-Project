package hibernate_onetoone_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_onetoone_uni.dto.AdharCard;
import hibernate_onetoone_uni.dto.Person;

public class PersonDao 
{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void savePerson(Person person)
	{
//		AdharCard adharCard = person.getAdharCard();
		
		entityTransaction.begin();
//		entityManager.persist(adharCard);
		entityManager.persist(person);
		entityTransaction.commit();
	}
	
	public void findPerson(int id)
	{
	    Person person = entityManager.find(Person.class, id) ;
	    
	    if(person != null)
	    {
	    	System.out.println(person);
	    }
	    else
	    {
	    	System.out.println("Data Not available!!!");
	    }    
	}
	
	public void deletePerson(int id)
	{
	    Person person = entityManager.find(Person.class, id) ;
	    if(person!=null)
	    {
	    	entityTransaction.begin();
//	    	entityManager.remove(person.getAdharCard());
	    	entityManager.remove(person);
	    	entityTransaction.commit();
	    }
	    else
	    {
	    	System.out.println("Data Not available!!!");
	    }
	}
	
	public void updateData(int id, Person person)
	{
		Person dbperson = entityManager.find(Person.class, id) ;
		
		if(dbperson != null)
		{
			person.setId(id);
			
			entityTransaction.begin();
//			entityManager.merge(person.getAdharCard());
			entityManager.merge(person) ;
			entityTransaction.commit();
			
		}
		else
		{
			System.out.println("Data Not Avaialable");
		}
	}
	
	public void updateOnlyPerson(int id,Person person)
	{
      Person dbperson = entityManager.find(Person.class, id) ;
		
		if(dbperson != null)
		{
			person.setId(id);
			person.setAdharCard(dbperson.getAdharCard()); //if you forget to set Adharcard the mapping will be come will be null
			
			entityTransaction.begin();
			entityManager.merge(person) ;
			entityTransaction.commit();
			
		}
		else
		{
			System.out.println("Data Not Avaialable");
		}
	}

}


