package hibernate_manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_manytoone.dao.CollegeDao;
import hibernate_manytoone.dao.StudentDao;
import hibernate_manytoone.dto.College;
import hibernate_manytoone.dto.Student;

public class MainController 
{
	public static void main(String[] args) {
		
		College college = new College();
//		
//		college.setId(101);
//		college.setName("FC");
//		college.setFees(100000);
		
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("Sanjana");
		s1.setPhone(9325303716l);
		s1.setAddress("Pune");
//		s1.setCollege(college);
		
		Student s2 = new Student();
		s2.setId(2);
		s2.setName("Rushi");
		s2.setPhone(9325303716l);
		s2.setAddress("Pune");
//		s2.setCollege(college);
		
		Student s3 = new Student();
		s3.setId(3);
		s3.setName("Vishal");
		s3.setPhone(9325303716l);
		s3.setAddress("Pune");
//		s3.setCollege(college);


//		dao.saveStudent(s1);
//		dao.saveStudent(s2);
//		dao.saveStudent(s3);
		
//		CollegeDao dao = new CollegeDao();
//		dao.saveCollege(college);
		
		StudentDao sdao = new StudentDao();
//		sdao.saveStudent(s1, 101);
//		sdao.saveStudent(s2, 101);
//		sdao.saveStudent(s3, 101);
		
		sdao.findStudent(5);
		
//		sdao.findAllStudent();
		
//		sdao.deleteStudent(6);
		
		sdao.updateStudent(1, s1);
	}
}
