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

    Person youngest(Person aPerson) {
        return isYoungerThan(aPerson) ? this : aPerson;
    }

    Person oldest(Person aPerson) {
        return isYoungerThan(aPerson) ? aPerson : this;
    }

    private boolean isYoungerThan(Person anotherPerson) {
        return birthDate().getTime() < anotherPerson.birthDate().getTime();
    }
}

