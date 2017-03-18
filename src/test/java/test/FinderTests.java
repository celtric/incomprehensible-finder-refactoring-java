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

        Optional<Result> result = finder().Find(Criteria.Closest);

        assertEquals(sue, result.get().youngest());
        assertEquals(greg, result.get().oldest());
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        list.add(mike);
        list.add(greg);

        Optional<Result> result = finder().Find(Criteria.Farthest);

        assertEquals(greg, result.get().youngest());
        assertEquals(mike, result.get().oldest());
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Optional<Result> result = finder().Find(Criteria.Farthest);

        assertEquals(sue, result.get().youngest());
        assertEquals(sarah, result.get().oldest());
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Optional<Result> result = finder().Find(Criteria.Closest);

        assertEquals(sue, result.get().youngest());
        assertEquals(greg, result.get().oldest());
    }

    private Finder finder() {
        return new Finder(list);
    }
}
