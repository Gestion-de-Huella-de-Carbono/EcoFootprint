package ecoFootprint.exception;

import java.text.MessageFormat;

public class PersonNotFoundException extends PersonException {
	public PersonNotFoundException(String personasNoEncontradas) {
		super("Person not found");
	}

	public PersonNotFoundException(String name, String lastName){
		super(MessageFormat.format("Person not found: {0} {1}", name, lastName));
	}
}
