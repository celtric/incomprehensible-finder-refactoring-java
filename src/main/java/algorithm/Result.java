package algorithm;

public class Result {
	private final Person left;
	private final Person right;

	private Result(Person left, Person right) {
		this.left = left;
		this.right = right;
	}

	static Result fromPeople(Person left, Person right) {
		if (left.birthDate().getTime() < right.birthDate().getTime()) {
			return new Result(left, right);
		} else {
			return new Result(right, left);
		}
	}

	public Person left() {
		return left;
	}

	public Person right() {
		return right;
	}

	long ageDifference() {
		return right.birthDate().getTime() - left.birthDate().getTime();
	}
}
