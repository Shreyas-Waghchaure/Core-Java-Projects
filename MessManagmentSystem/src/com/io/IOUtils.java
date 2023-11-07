package com.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.app.core.Customer;

public interface IOUtils {

	static void store(List<Customer>cList,String fName) throws FileNotFoundException, IOException {
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fName))){
			out.writeObject(cList);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	static List<Customer> reStore(String fName) throws FileNotFoundException, IOException{
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fName))){
			return (List<Customer>)in.readObject();
		}catch(Exception e) {
			System.out.println(e);
			return new ArrayList<Customer>();
		
		}
	}
	
}
