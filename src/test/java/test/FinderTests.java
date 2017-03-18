package test;

import algorithm.Criteria;
import algorithm.Finder;
import algorithm.Person;
import algorithm.Result;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FinderTests {

    private final Person sue = new Person(new Date(50, 0, 1));
    private final Person greg = new Person(new Date(52, 5, 1));
    private final Person sarah = new Person(new Date(82, 0, 1));
    private final Person mike = new Person(new Date(79, 0, 1));
    private final List<Person> list = new ArrayList<>();

    @Test
    public void Returns_Empty_Results_When_Given_Empty_List() {
        Optional<Result> result = finder().Find(Criteria.Closest);

        assertFalse(result.isPresent());
    }

    @Test
    public void Returns_Empty_Results_When_Given_One_Person() {
        list.add(sue);

        Optional<Result> result = finder().Find(Criteria.Closest);

        assertFalse(result.isPresent());
    }

    @Test
    public void Returns_Closest_Two_For_Two_People() {
        list.add(sue);
        list.add(greg);

        Result result = finder().Find(Criteria.Closest).orElseThrow(() -> new RuntimeException("Expected a result"));

        assertEquals(sue, result.youngest());
        assertEquals(greg, result.oldest());
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        list.add(mike);
        list.add(greg);

        Result result = finder().Find(Criteria.Farthest).orElseThrow(() -> new RuntimeException("Expected a result"));

        assertEquals(greg, result.youngest());
        assertEquals(mike, result.oldest());
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Result result = finder().Find(Criteria.Farthest).orElseThrow(() -> new RuntimeException("Expected a result"));

        assertEquals(sue, result.youngest());
        assertEquals(sarah, result.oldest());
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Result result = finder().Find(Criteria.Closest).orElseThrow(() -> new RuntimeException("Expected a result"));

        assertEquals(sue, result.youngest());
        assertEquals(greg, result.oldest());
    }

    private Finder finder() {
        return new Finder(list);
    }
}
