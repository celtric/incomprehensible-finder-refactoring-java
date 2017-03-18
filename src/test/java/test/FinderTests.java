package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import algorithm.Result;
import algorithm.Criteria;
import algorithm.Finder;
import algorithm.Person;

public class FinderTests {

	private final Person sue = new Person(new Date(50, 0, 1));
	private final Person greg = new Person(new Date(52, 5, 1));
	private final Person sarah = new Person(new Date(82, 0, 1));
	private final Person mike = new Person(new Date(79, 0, 1));

	@Test
	public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Person> list = new ArrayList<Person>();
		Finder finder = new Finder(list);

		Result result = finder.Find(Criteria.One);
		assertEquals(null, result.left());

		assertEquals(null, result.right());
	}

	@Test
	public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);

		Finder finder = new Finder(list);

		Result result = finder.Find(Criteria.One);

		assertEquals(null, result.left());
		assertEquals(null, result.right());
	}

	@Test
	public void Returns_Closest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(greg);
		Finder finder = new Finder(list);

		Result result = finder.Find(Criteria.One);

		assertEquals(sue, result.left());
		assertEquals(greg, result.right());
	}

	@Test
	public void Returns_Furthest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		Result result = finder.Find(Criteria.Two);

		assertEquals(greg, result.left());
		assertEquals(mike, result.right());
	}

	@Test
	public void Returns_Furthest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);
		Finder finder = new Finder(list);

		Result result = finder.Find(Criteria.Two);

		assertEquals(sue, result.left());
		assertEquals(sarah, result.right());
	}

	@Test
	public void Returns_Closest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		Result result = finder.Find(Criteria.One);

		assertEquals(sue, result.left());
		assertEquals(greg, result.right());
	}

}
