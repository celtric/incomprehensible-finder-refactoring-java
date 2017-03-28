package algorithm;

import java.util.Date;

public final class Person {

    private final Date birthDate;

    public Person(Date birthDate) {
        this.birthDate = birthDate;
    }

    static Person youngest(Person a, Person b) {
        return a.isYoungerThan(b) ? a : b;
    }

    static Person oldest(Person a, Person b) {
        return a.isYoungerThan(b) ? b : a;
    }

    private boolean isYoungerThan(Person anotherPerson) {
        return birthDate.getTime() < anotherPerson.birthDate.getTime();
    }

    long ageDifference(Person anotherPerson) {
        return birthDate.getTime() - anotherPerson.birthDate.getTime();
    }
}

