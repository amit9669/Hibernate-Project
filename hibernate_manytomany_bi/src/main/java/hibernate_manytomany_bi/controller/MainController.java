package hibernate_manytomany_bi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_manytomany_bi.dto.Course;
import hibernate_manytomany_bi.dto.Student;

public class MainController {

	public static void main(String[] args) {
		
	 Course course1 = new Course(); 
	 course1.setName("Java");
	 course1.setFees(20000);
	 course1.setDuration(4);
	 
	 Course course2 = new Course(); 
	 course2.setName("J2EE");
	 course2.setFees(12000);
	 course2.setDuration(2.5);
	 
	 Course course3 = new Course(); 
	 course3.setName("Selenium");
	 course3.setFees(10000);
	 course3.setDuration(1.5);
	 
	 

	 Student student1 = new Student();
	 student1.setName("Vishal");
	 student1.setEmail("vishal@");
	 student1.setPhone(9377660022l);
	 
	 Student student2 = new Student();
	 student2.setName("Rushi");
	 student2.setEmail("rushi@");
	 student2.setPhone(9233244550l);
	 
	 Student student3 = new Student();
	 student3.setName("Amit");
	 student3.setEmail("amit@");
	 student3.setPhone(9325303716l);
	 
	 List<Student> listS1 = new ArrayList<Student>();
	 listS1.add(student1);
	 listS1.add(student2);
	 listS1.add(student3); 
	 course1.setStudents(listS1);
	 
	 List<Student> listS2 = new ArrayList<Student>();
	 listS2.addAll(listS1);
	 listS2.remove(student1) ;	 
	 course2.setStudents(listS2);
	 
	 List<Student> listS3 = new ArrayList<Student>();
	 listS3.addAll(listS1);
	 listS3.remove(student2) ;
	 course3.setStudents(listS3);
	 
	 List<Course> listC1 = new ArrayList<Course>();
	 listC1.add(course1);
	 listC1.add(course3);
	 student1.setCourses(listC1);
	 
	 List<Course> listC2 = new ArrayList<Course>();
	 listC2.add(course1);
	 listC2.add(course2);
	 student2.setCourses(listC2);
	 
	 List<Course> listC3 = new ArrayList<Course>();
	 listC3.addAll(listC2);
	 listC3.add(course3);
	 student3.setCourses(listC3);
	 
	 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
	 EntityManager entityManager = entityManagerFactory.createEntityManager();
	 EntityTransaction entityTransaction = entityManager.getTransaction();
	 
	 entityTransaction.begin();
	 entityManager.persist(student1);
	 entityManager.persist(student2);
	 entityManager.persist(student3);
	 entityManager.persist(course1);
	 entityManager.persist(course2);
	 entityManager.persist(course3);
	 entityTransaction.commit();
	 
	}
}
