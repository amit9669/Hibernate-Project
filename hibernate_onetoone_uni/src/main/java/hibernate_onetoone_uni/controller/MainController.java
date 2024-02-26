package hibernate_onetoone_uni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_onetoone_uni.dao.AdharCardDao;
import hibernate_onetoone_uni.dao.PersonDao;
import hibernate_onetoone_uni.dto.AdharCard;
import hibernate_onetoone_uni.dto.Person;

public class MainController {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in) ;
//		System.out.println("\n1.Add Person : ");
//		System.out.println("Enter Your Choice : ");	
//		int choice = scanner.nextInt();
		AdharCard adharCard = new AdharCard();
		Person person = new Person() ;
		PersonDao dao = new PersonDao();
		AdharCardDao adao = new AdharCardDao();
		
//		
//		switch (choice) {
//		case 1:
//		{
//			System.out.println("Enter Adharcard ID :");
//			int aid = scanner.nextInt();
//			System.out.println("Enter Adhcard Name : ");
//			String aName = scanner.next();
//			System.out.println("Enter Adrdress On Adharcard : ");
//			String aAddress = scanner.next();
//			
//			System.out.println("Enter Person Id :");
//			int id = scanner.nextInt();
//			System.out.println("Enter Person Name : ");
//			String name = scanner.next();
//			System.out.println("Enter Person Address : ");
//			String address = scanner.next();
//			System.out.println("Enter Person Mobile Number : ");
//			long phone = scanner.nextLong();
//			
//			adharCard.setId(aid);
//			adharCard.setName(aName);
//			adharCard.setAddress(address);
//					
//			person.setId(id);
//			person.setName(name);
//			person.setAddress(address);
//			person.setPhone(phone) ;
//			person.setAdharCard(adharCard);
//			
//			dao.savePerson(person);
//			
//		}
//		break;
//
//		default:
//			break;
//		}
//		
		adharCard.setId(101);
		adharCard.setName("Amit");
		adharCard.setAddress("Islampur");
		
		
		person.setId(1);
		person.setName("Amit");
		person.setAddress("Pune");
		person.setPhone(8766884081l) ;
		person.setAdharCard(adharCard);
		
//  	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("amit") ;
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		entityManager.persist(adharCard);
//		entityManager.persist(person);
//		entityTransaction.commit();
		
		
//		dao.savePerson(person);	
//		dao.findPerson(1);		
//		adao.deletePerson(102);
		
		dao.deletePerson(1) ;

//		adharCard.setId(1);
//		adharCard.setName("Amit");
//		adharCard.setAddress("Islampur");	
//		person.setId(1);
//		person.setName("Sanjana");
//		person.setAddress("Sangli");
//		person.setPhone(8766884081l);
//		person.setAdharCard(adharCard);
//		dao.updateData(1, person);
		
//		person.setId(1);
//		person.setName("Sanjana");
//		person.setAddress("Sangli");
//		person.setPhone(8766884081l);	
//		dao.updateOnlyPerson(1, person);
	}
}
