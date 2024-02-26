package hibernate_manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_manytoone.dto.College;

public class CollegeDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void saveCollege(College college)
	{
		entityTransaction.begin();
		entityManager.persist(college);
		entityTransaction.commit();
	}
}
