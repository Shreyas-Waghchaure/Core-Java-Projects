package utils;

import java.util.List;

import com.app.core.Reader;

import customerExceptions.InvalidInputException;

public class ReaderUtils {

	public static Reader validateEmail(String email,List<Reader> reader) throws InvalidInputException{
		
		Reader red = new Reader(email);
		int index = reader.indexOf(red);
		if(index == -1) {
			throw new InvalidInputException("Invalid Email");
		}
		
		return reader.get(index);
	}
	
	
	public static Reader authenticate(String email,String password,List<Reader> readerList) throws InvalidInputException {
		
		Reader reader = validateEmail(email, readerList);
		
		if(!reader.getPassword().equals(password)) {
			throw new InvalidInputException("Invalid password...");
		}
		return reader;
	}
	
}
