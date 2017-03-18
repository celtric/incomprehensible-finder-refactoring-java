package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Result Find(Criteria criteria) {
		List<Result> results = new ArrayList<Result>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				results.add(Result.fromPeople(people.get(i), people.get(j)));
			}
		}

		return results.stream().reduce(criteria::calculate).orElse(Result.empty());
	}
}
