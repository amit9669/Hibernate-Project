package hibernate_onetomany.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hibernate_onetomany.dto.Company;

public class CacheExecution
{
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("amit") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.find(Company.class, 101) ;
		entityManager.find(Company.class, 101) ;
		
		EntityManager entityManager2 = entityManagerFactory.createEntityManager();
		
		entityManager2.find(Company.class, 101) ;
		entityManager2.find(Company.class, 101) ;
		
        EntityManager entityManager3 = entityManagerFactory.createEntityManager();
		
		entityManager3.find(Company.class, 102) ;
		entityManager3.find(Company.class, 102) ;
		
		
	}
}
