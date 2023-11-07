package tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.core.Reader;
import static validations.ValidationRules.*;
import static utils.ReaderUtils.*;
public class LibraryTester {
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			
			List<Reader>readerList = new ArrayList<>();
			boolean exit = false;
			
			while(!exit) {
				
				System.out.println("1. Sign up (Reader registration)\n" + 
						"2. Sign in (login)\n" + 
						"3. Change password\n" + 
						"4. Un subscribe Reader\n" + 
						"i/p : Reader email\n" + 
						"5. Display all Readers.\n" + 
						"0. Exit\n");
				
				System.out.println("Enter choice:");
				try {
				switch(sc.nextInt()) {
				case 1:
					System.out.println("Reader Registration");
					System.out.println("Enter Reader details:firstName,  lastName,  email,  password,  regAmount,\n" + 
							"dob, Membership Plan");
					readerList.add(validateAllRules(sc.next(),sc.next() , sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next().toUpperCase(), readerList));
					break;
				case 2:
					System.out.println("Enter email and password:");
					authenticate(sc.next(), sc.next(), readerList);
					System.out.println("Login Successful...!");
					break;
				case 3:
					System.out.println("Enter email address and old Password:");
					Reader reader =authenticate(sc.next(), sc.next(), readerList);
					System.out.println("Enter new password");
					reader.setPassword(sc.next());
					
					break;
				case 4:
					System.out.println("Enter email address:");
					Reader r = new Reader(sc.next());
					readerList.remove(r);
					System.out.println("Reader unsubscribed....");
					
				case 5:
					readerList.forEach(System.out::println);
					break;
				}
			
			}catch(Exception e) {
				sc.nextLine();
				System.out.println(e.getMessage());
			}
			}
		}
	}
	
}
