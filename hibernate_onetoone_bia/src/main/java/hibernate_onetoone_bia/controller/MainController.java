package hibernate_onetoone_bia.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_onetoone_bia.dao.PersonDao;
import hibernate_onetoone_bia.dto.AdharCard;
import hibernate_onetoone_bia.dto.Person;

public class MainController 
{
	public static void main(String[] args)
	{
		AdharCard adharCard = new AdharCard() ;
		Person person = new Person();
		PersonDao pdao = new PersonDao();
		Scanner scanner = new Scanner(System.in) ;
		System.out.println("1.Add Person : \n2.Find Person By ID :");
		System.out.println("Enter Your Choice : ");	
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
		{
			System.out.println("Enter Adhcard Name : ");
			String aName = scanner.next();
			System.out.println("Enter Address On Adharcard : ");
			String aAddress = scanner.next();
			
			System.out.println("Enter Person Name : ");
			String pname = scanner.next();
			System.out.println("Enter Person Address : ");
			String pAddress = scanner.next();
			System.out.println("Enter Person Mobile Number : ");
			long pPhone = scanner.nextLong();
			
			adharCard.setName(pname);
			adharCard.setAddress(pAddress);
			person.setName(pname);
			person.setAddress(pAddress);
			person.setPhone(pPhone);
			
			adharCard.setPerson(person);
			person.setAdharCard(adharCard);
			
			pdao.savePerson(person);
		}
		break;
		case 2:
		{
			System.out.println("Enter Person Id who's search you : ");
			int pid = scanner.nextInt();
			
			pdao.findPerson(pid);
		}
		break ;

		default:
			break;
		}
		
//		adharCard.setName("Amit");
//		adharCard.setAddress("Islampur");
//		
//		Person person = new Person();
//		
//		person.setName("Amit");
//		person.setPhone(9325303716l);
//		person.setAddress("pune");
//		
//		adharCard.setPerson(person);
//		person.setAdharCard(adharCard);
//		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		
////		entityTransaction.begin();
////		entityManager.persist(person);
////		entityManager.persist(adharCard);
////		entityTransaction.commit();
//		
////		Person person2=entityManager.find(Person.class, 1);
////		System.out.println(person2);
//		AdharCard adharCard2=entityManager.find(AdharCard.class, 1);
//		System.out.println(adharCard2);
	}
}
