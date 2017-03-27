package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class Finder {

    private final List<Person> people;

    public Finder(List<Person> people) {
        this.people = people;
    }

    public Optional<Pair> Find(Criteria criteria) {
        return pairs().stream().reduce(criteria::choose);
    }

    private List<Pair> pairs() {
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                pairs.add(Pair.fromUnordered(people.get(i), people.get(j)));
            }
        }

        return pairs;
    }
}
