package hibernate_onetoone_bia.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_onetoone_bia.dto.AdharCard;
import hibernate_onetoone_bia.dto.Person;

public class PersonDao 
{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void savePerson(Person person)
	{
	  AdharCard adharCard = person.getAdharCard();
	  
	  entityTransaction.begin();
	  entityManager.persist(adharCard);
	  entityManager.persist(person);
	  entityTransaction.commit();
	}
	
	public void findPerson(int id)
	{
		Person person = entityManager.find(Person.class, id) ;
		if(person!=null)
		{
			System.out.println(person);
		}
		else
		{
			System.out.println("Id Not Present!!!");
		}
	}
}
