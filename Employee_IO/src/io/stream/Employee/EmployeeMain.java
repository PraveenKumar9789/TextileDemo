package io.stream.Employee;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		int in=0;
		String filename= "Employee.ser";
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		FileInputStream fis = new FileInputStream(filename);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		do {
			System.out.println("Main Menu");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All");
            System.out.println("3. Exit");
            in = sc.nextInt();
            switch(in) {
            case 1:
            	Employee emp = new Employee();
            	int s = 1;
            	System.out.print("Enter employee ID: ");
            	emp.setId(sc.nextInt());
            	System.out.print("Enter employee name:");
            	emp.setName(sc.next());
            	System.out.print("Enter employee age:");
            	emp.setAge(sc.nextInt());
            	System.out.println("Enter employee ecperience:");
            	emp.setExperience(sc.nextInt());
            	oos.writeObject(emp);
            	break;
            case 2:
            	System.out.println("---------Report------");
            	while(fis.available()>0) {
            		emp = (Employee) ois.readObject();
            		System.out.println(emp);
            	}
            	System.out.println("----End of Report-----");
                break;
            case 3:
                System.out.println("Exiting the System");
            }
            	
            
		}while(in!=3);
		fos.close();
        oos.close();
        fis.close();
        ois.close();
        sc.close();

	}

}
