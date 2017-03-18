package algorithm;

public enum Criteria {
	Closest {
		@Override
		Result calculate(Result lastResult, Result nextResult) {
			if (nextResult.ageDifference() < lastResult.ageDifference()) {
				return nextResult;
			} else {
				return lastResult;
			}
		}
	},

	Farthest {
		@Override
		Result calculate(Result lastResult, Result nextResult) {
			if (nextResult.ageDifference() > lastResult.ageDifference()) {
				return nextResult;
			} else  {
				return lastResult;
			}
		}
	};

	abstract Result calculate(Result lastResult, Result nextResult);
}
