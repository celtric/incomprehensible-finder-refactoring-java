package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Result Find(FT ft) {
		List<Result> results = new ArrayList<Result>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				Result r = new Result();
				if (people.get(i).birthDate().getTime() < people.get(j).birthDate().getTime()) {
					r.P1 = people.get(i);
					r.P2 = people.get(j);
				} else {
					r.P1 = people.get(j);
					r.P2 = people.get(i);
				}
				r.D = r.P2.birthDate().getTime() - r.P1.birthDate().getTime();
				results.add(r);
			}
		}

		if (results.size() < 1) {
			return new Result();
		}

		Result answer = results.get(0);
		for (Result result : results) {
			switch (ft) {
				case One :
					if (result.D < answer.D) {
						answer = result;
					}
					break;

				case Two :
					if (result.D > answer.D) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}
}
