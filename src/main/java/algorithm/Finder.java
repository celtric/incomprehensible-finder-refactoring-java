package algorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Optional<Result> Find(Criteria criteria) {
		return results().stream().reduce(criteria::choose);
	}

	private List<Result> results() {
		List<Result> results = new ArrayList<>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				results.add(Result.fromPair(people.get(i), people.get(j)));
			}
		}

		return results;
	}
}
