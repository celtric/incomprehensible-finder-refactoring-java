package algorithm;

public class Result {
	private final Person younger;
	private final Person older;

	private Result(Person younger, Person older) {
		this.younger = younger;
		this.older = older;
	}

	static Result fromPair(Person left, Person right) {
		if (left.isYoungerThan(right)) {
			return new Result(left, right);
		} else {
			return new Result(right, left);
		}
	}

	public Person left() {
		return younger;
	}

	public Person right() {
		return older;
	}

	long ageDifference() {
		return older.birthDate().getTime() - younger.birthDate().getTime();
	}
}
