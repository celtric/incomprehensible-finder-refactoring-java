package test;

import algorithm.Criteria;
import algorithm.Finder;
import algorithm.Pair;
import algorithm.Person;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public final class FinderTests {

    private final Person sue = new Person(new Date(50, 0, 1));
    private final Person greg = new Person(new Date(52, 5, 1));
    private final Person sarah = new Person(new Date(82, 0, 1));
    private final Person mike = new Person(new Date(79, 0, 1));
    private final List<Person> list = new ArrayList<>();

    @Test
    public void Returns_Empty_Results_When_Given_Empty_List() {
        Optional<Pair> result = finder().Find(Criteria.Closest);

        assertFalse(result.isPresent());
    }

    @Test
    public void Returns_Empty_Results_When_Given_One_Person() {
        list.add(sue);

        Optional<Pair> result = finder().Find(Criteria.Closest);

        assertFalse(result.isPresent());
    }

    @Test
    public void Returns_Closest_Two_For_Two_People() {
        list.add(sue);
        list.add(greg);

        Pair pair = finder().Find(Criteria.Closest).orElseThrow(() -> new RuntimeException("Expected a pair"));

        assertEquals(sue, pair.youngest());
        assertEquals(greg, pair.oldest());
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        list.add(mike);
        list.add(greg);

        Pair pair = finder().Find(Criteria.Furthest).orElseThrow(() -> new RuntimeException("Expected a pair"));

        assertEquals(greg, pair.youngest());
        assertEquals(mike, pair.oldest());
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Pair pair = finder().Find(Criteria.Furthest).orElseThrow(() -> new RuntimeException("Expected a pair"));

        assertEquals(sue, pair.youngest());
        assertEquals(sarah, pair.oldest());
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Pair pair = finder().Find(Criteria.Closest).orElseThrow(() -> new RuntimeException("Expected a pair"));

        assertEquals(sue, pair.youngest());
        assertEquals(greg, pair.oldest());
    }

    private Finder finder() {
        return new Finder(list);
    }
}
