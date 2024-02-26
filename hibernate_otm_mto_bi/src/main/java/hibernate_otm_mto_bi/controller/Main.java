package hibernate_otm_mto_bi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hibernate_otm_mto_bi.dto.Company;
import hibernate_otm_mto_bi.dto.Employee;

public class Main 
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in) ;
		System.out.println("n\1.Save Employee : ");
		System.out.println("Enter the Choice : ");
		int choice = scanner.nextInt();
		
		Employee employee = new Employee();
		Company company = new Company();
		
		
		switch (choice) {
		case 1:
		{
			System.out.println("Enter Compnay Name : ");
			String cname = scanner.next();
			System.out.println("Enter Company GST : ");
			String gst = scanner.next();
			
			System.out.println("Enter Employee Name : ");
			String ename = scanner.next();
			System.out.println("Enter Employee Address : ");
			String address = scanner.next();
			System.out.println("Enter Employee Phone Number : ");
			long phone = scanner.nextLong();
			
			company.setName(cname);
			company.setGst(gst);
			
			employee.setName(ename);
			employee.setAddress(address);
			employee.setPhone(phone);
			
			List<Employee> list = new ArrayList<Employee>();
			list.add(employee);
			
			company.setEmployees(list);
			
		}
	    break;
	    
		default:
			break;
		}
	}
}
