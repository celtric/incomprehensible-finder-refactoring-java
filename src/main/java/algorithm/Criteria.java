package algorithm;

public enum Criteria {
	One {
		@Override
		Result calculate(Result lastResult, Result nextResult) {
			if (nextResult.ageDifference() < lastResult.ageDifference()) {
				return nextResult;
			} else {
				return lastResult;
			}
		}
	},

	Two {
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
