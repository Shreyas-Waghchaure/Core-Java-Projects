package validations;

import java.time.LocalDate;
import java.util.List;

import com.app.core.Reader;
import com.app.core.ServicePlan;

import customerExceptions.InvalidInputException;

public class ValidationRules {

	public static ServicePlan parseAndValidatePlan(String plan) throws InvalidInputException {
		try {
			return ServicePlan.valueOf(plan);
		}catch(Exception e){
			throw new InvalidInputException("Invalid Plan..."); 
		}
	}
	
	public static void validateAmount(ServicePlan plan,double amt)throws InvalidInputException {
		
		if(amt != plan.getPlanAmount())
			throw new InvalidInputException("Registration amount and plan amount doesn't match..");
	}
	
	public static void noDupReader(List<Reader> readers,String email) throws InvalidInputException {
		Reader r = new Reader(email);
		if(readers.contains(r)) {
			throw new InvalidInputException("email address should be unique...");
		}
		
	}
	
	public static Reader validateAllRules(String firstName, String lastName, String email, String password, double regAmount,
			String dob, String memPlan,List<Reader> reader) throws InvalidInputException{
			
			ServicePlan plan = parseAndValidatePlan(memPlan);
			
			validateAmount(plan, regAmount);
			
			noDupReader(reader, email);
			
		return new Reader(firstName, lastName, email, password, regAmount, LocalDate.parse(dob), plan);
		
	}
	
	
	
	
}
