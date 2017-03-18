package algorithm;

import java.util.Date;

public class Person {

	private final Date birthDate;

	public Person(Date birthDate) {
		this.birthDate = birthDate;
	}

	Date birthDate() {
		return birthDate;
	}
}

