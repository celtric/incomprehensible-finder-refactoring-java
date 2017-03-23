package algorithm;

public enum Criteria {
    Closest {
        @Override
        Result choose(Result left, Result right) {
            return left.ageDifference() < right.ageDifference() ? left : right;
        }
    },

    Furthest {
        @Override
        Result choose(Result left, Result right) {
            return left.ageDifference() > right.ageDifference() ? left : right;
        }
    };

    abstract Result choose(Result left, Result right);
}
