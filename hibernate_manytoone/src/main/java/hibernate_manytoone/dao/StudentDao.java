package hibernate_manytoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_manytoone.dto.College;
import hibernate_manytoone.dto.Student;

public class StudentDao 
{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void saveStudent(Student student, int c_id)
	{
		College college = entityManager.find(College.class, c_id) ;
		if(college!=null)
		{
			student.setCollege(college);
			
			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("College with the given id "+c_id + " Not Found");
		}
	}
	
	public void findStudent(int id)
	{
		 Student student = entityManager.find(Student.class, id) ;
		 
		 if(student!=null)
		 {
			 System.out.println(student);
		 }
		 else
		 {
			 System.out.println("Student id "+ id + " Not Found");
		 }
	}
	
	public void findAllStudent()
	{
		Query query = entityManager.createQuery("select s from Student s") ;
		System.out.println(query.getResultList());
	}
	
	public void deleteStudent(int id)
	{
		Student student = entityManager.find(Student.class, id) ;
		
		if(student!=null)
		{
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Student id "+ id + " Not Found");
		}
	}
	
	public void updateStudent(int id, Student student)
	{
		Student dbstudent = entityManager.find(Student.class, id) ;
		
		if(dbstudent != null)
		{
			student.setId(id);
			student.setCollege(dbstudent.getCollege());
			
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Student id "+ id + " Not Found");
		}
	}
	
}
