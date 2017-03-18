package algorithm;

public class Result {
	private final Person left;
	private final Person right;
	private final long ageDifference;

	private Result(Person left, Person right, long ageDifference) {
		this.left = left;
		this.right = right;
		this.ageDifference = ageDifference;
	}

	static Result fromPeople(Person left, Person right) {
		if (left.birthDate().getTime() < right.birthDate().getTime()) {
			return new Result(left, right, right.birthDate().getTime() - left.birthDate().getTime());
		} else {
			return new Result(right, left, left.birthDate().getTime() - right.birthDate().getTime());
		}
	}

	public Person left() {
		return left;
	}

	public Person right() {
		return right;
	}

	long ageDifference() {
		return ageDifference;
	}
}
