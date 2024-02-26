package hibernate_manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_manytomany.dao.LanguageDao;
import hibernate_manytomany.dao.PersonDao;
import hibernate_manytomany.dto.Language;
import hibernate_manytomany.dto.Person;

public class MainController {

	public static void main(String[] args) 
	{	
		Language language1 = new Language();
		language1.setId(101);
		language1.setName("Marathi");
		language1.setOrigin("Maharashtra");
		
		Language language2 = new Language() ;
		language2.setId(102);
		language2.setName("English");
		language2.setOrigin("UK");
		
		Language language3 = new Language();
		language3.setId(103);
		language3.setName("Kannada");
		language3.setOrigin("Karnataka");
		
		Person person1 = new Person();
		person1.setId(1);
		person1.setName("Amit");
		person1.setPhone(9325303716l);
		person1.setAddress("Pune");
		List<Language> list1 = new ArrayList<Language>();
	    list1.add(language1) ;
	    list1.add(language2) ;
		person1.setLangauges(list1);
		
		Person person2 = new Person();
		person2.setId(2);
		person2.setName("Rushi");
		person2.setPhone(9876543211l);
		person2.setAddress("Latur");
		List<Language> list2 = new ArrayList<Language>();
	    list2.add(language1) ;
	    list2.add(language2) ; 
		person2.setLangauges(list2);
		
		Person person3 = new Person();
		person3.setId(3);
		person3.setName("Vishal");
		person3.setPhone(9876543211l);
		person3.setAddress("Kolhapur");
		List<Language> list3 = new ArrayList<Language>();
	    list3.addAll(list1) ;
	    list3.add(language3) ; 
		person3.setLangauges(list3);
		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		entityManager.persist(language1);
//		entityManager.persist(language2);
//		entityManager.persist(language3);
//		entityManager.persist(person1);
//		entityManager.persist(person2);
//		entityManager.persist(person3);
//		entityTransaction.commit();
		
//		LanguageDao ldao = new LanguageDao();
//		ldao.saveLanguage(language1);
//		ldao.saveLanguage(language2);
//		ldao.saveLanguage(language3);
	}
}
