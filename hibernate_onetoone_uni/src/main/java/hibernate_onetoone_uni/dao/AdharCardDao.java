package hibernate_onetoone_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_onetoone_uni.dto.AdharCard;

public class AdharCardDao 
{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void deletePerson(int id)
	{
		AdharCard adharCard = entityManager.find(AdharCard.class, id) ;
		
		if(adharCard != null)
		{
			entityTransaction.begin();
			entityManager.remove(adharCard);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Data Not Available!!!");
		}
	}
}
