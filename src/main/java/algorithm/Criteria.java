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

// public enum Criteria {
//
//     Closest((a, b) -> a.ageDifference() < b.ageDifference() ? a : b),
//     Furthest((a, b) -> a.ageDifference() > b.ageDifference() ? a : b);
//
//     private final Chooser chooser;
//
//     interface Chooser {
//         Result choose(Result left, Result right);
//     }
//
//     Criteria(Chooser chooser) {
//         this.chooser = chooser;
//     }
//
//     Result choose(Result left, Result right) {
//         return chooser.choose(left, right);
//     }
// }
