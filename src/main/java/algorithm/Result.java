package algorithm;

public class Result {
	private final Person youngest;
	private final Person oldest;

	private Result(Person youngest, Person oldest) {
		this.youngest = youngest;
		this.oldest = oldest;
	}

	static Result fromPair(Person left, Person right) {
		if (left.isYoungerThan(right)) {
			return new Result(left, right);
		} else {
			return new Result(right, left);
		}
	}

	public Person youngest() {
		return youngest;
	}

	public Person oldest() {
		return oldest;
	}

	long ageDifference() {
		return oldest.birthDate().getTime() - youngest.birthDate().getTime();
	}
}
