package hibernate_manytomany.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hibernate_manytomany.dao.LanguageDao;
import hibernate_manytomany.dao.PersonDao;
import hibernate_manytomany.dto.Language;
import hibernate_manytomany.dto.Person;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in) ;
		System.out.println("\n1.Language Interface: \n2.Person Interface:");
		System.out.println("Enter Choice: ");
		Person person = new Person() ;
		Language language = new Language() ;
		LanguageDao ldao = new LanguageDao() ;
		PersonDao dao = new PersonDao();
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1:
		{
			System.out.println("Enter the Choice \n1.save Language: ");
			int key = scanner.nextInt();
			switch (key) {
			case 1:
			{
				System.out.println("Enter the id");
				language.setId(scanner.nextInt());
				System.out.println("Enter the Language Name : ");
				language.setName(scanner.next());
				System.out.println("Enter the Language Origin : ");
				language.setOrigin(scanner.next());
				ldao.saveLanguage(language);
			}
			break;
			default:
			break;
			}
		}
		break;
		case 2:
		{
			System.out.println("Enter the choice: \n1.Save Person: ");
			int key = scanner.nextInt();
			switch (key) {
			case 1:
			{
				ldao.getAllLanguages();
				
				System.out.println("How many language you need to add?");
				int size = scanner.nextInt();
				List<Integer> ids = new ArrayList<Integer>();
				
				for (int i = 1; i <= size; i++) 
				{
				   System.out.println("Enter the Language Id");
				   ids.add(scanner.nextInt()) ;
				}
				System.out.println("Enter the Id : ");
				person.setId(scanner.nextInt());
				System.out.println("Enter The Name ");
				person.setName(scanner.next());
				System.out.println("Enter The Phone Number : ");
				person.setPhone(scanner.nextLong());
				System.out.println("Enter The Address : ");
				person.setAddress(scanner.next());
				
				dao.savePerson(person, ids);
			}
			break;

			default:
				break;
			}
		}
		break ;
		default:
			break;
		}
	}
}
