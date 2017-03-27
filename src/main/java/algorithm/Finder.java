package algorithm;

import java.util.*;
import java.util.stream.Collectors;

public final class Finder {

    private final List<Person> people;

    public Finder(List<Person> people) {
        this.people = people;
    }

    public Optional<Pair> Find(Criteria criteria) {
        return pairs().stream().reduce(criteria::choose);
    }

    private Set<Pair> pairs() {
        Set<Pair> pairs = new HashSet<>();

        people.forEach(p -> people.forEach(p2 -> pairs.add(Pair.fromUnordered(p, p2))));

        return pairs.stream().filter(p -> !p.youngest().equals(p.oldest())).collect(Collectors.toSet());

        // for (Person person : people) {
        //     for (Person person2 : people) {
        //         if (!person.equals(person2)) {
        //             pairs.add(Pair.fromUnordered(person, person2));
        //         }
        //     }
        // }
        //
        // return pairs;
    }
}
