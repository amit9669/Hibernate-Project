package hibernate_manytomany.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_manytomany.dto.Language;
import hibernate_manytomany.dto.Person;

public class PersonDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
//	public void savePerson(Person person) 
//	{
//		List<Language> languages = person.getLangauges() ;
//		
//		entityTransaction.begin();
//		for(Language language : languages)
//		{
//			entityManager.persist(language);
//		}
//		entityManager.persist(languages);
//		entityTransaction.commit();
//	}
	
	public void savePerson(Person person, List<Integer> ids)
	{
		List<Language> list = new ArrayList<Language>();
		for(Integer id : ids)
		{
			Language language =entityManager.find(Language.class, id) ;
			list.add(language);
		}
		person.setLangauges(list);
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}
}
