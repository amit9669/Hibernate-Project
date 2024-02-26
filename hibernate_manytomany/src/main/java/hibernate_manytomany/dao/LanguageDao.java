package hibernate_manytomany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_manytomany.dto.Language;

public class LanguageDao 
{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
	public void saveLanguage(Language language)
	{
		entityTransaction.begin();
		entityManager.persist(language);
		entityTransaction.commit();
	}
	
	public void getAllLanguages()
	{
	  Query query = entityManager.createQuery("select l from Language l") ;
	  List <Language> list = query.getResultList();
	  System.out.println(list);
	}
}
