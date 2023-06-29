package kr.or.ddit.validate;

import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidateUtils {
	private static Validator validator;
	
	static {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	public static <T> boolean validate(T target, Map<String, String> errors, Class<?>...groups){
		Set<ConstraintViolation<T>> violations = validator.validate(target, groups);
		boolean valid = violations.isEmpty();
		if(!valid) {
			violations.stream().forEach(sv->{
				String key = sv.getPropertyPath().toString();
				String value = sv.getMessage();
				errors.put(key, value);
				System.out.printf("%s : %s\n", key, value);
			});
		}
		
		return valid;
	}
}










