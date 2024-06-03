package ecoFootprint.exception;

import java.text.MessageFormat;

public class PersonNotFoundException extends EcoFootprintException {
	public PersonNotFoundException() {
		super("Person not found");
	}

	public PersonNotFoundException(Long id) {
		super(MessageFormat.format("Person not found: ID {0}", id));
	}
}

