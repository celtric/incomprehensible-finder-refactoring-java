package algorithm;
public enum Criteria {
	One, Two;

	Result calculate(Result lastResult, Result nextResult) {

		switch (this) {
			case One :
				if (nextResult.ageDifference() < lastResult.ageDifference()) {
					return nextResult;
				} else {
					return lastResult;
				}

			case Two :
				if (nextResult.ageDifference() > lastResult.ageDifference()) {
					return nextResult;
				} else  {
					return lastResult;
				}
			default:
				throw new RuntimeException("Not implemented");
		}
	}
}
