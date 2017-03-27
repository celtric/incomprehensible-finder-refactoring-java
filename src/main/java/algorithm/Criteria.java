package algorithm;

public enum Criteria {
    Closest {
        @Override
        Pair choose(Pair left, Pair right) {
            return left.ageDifference() < right.ageDifference() ? left : right;
        }
    },

    Furthest {
        @Override
        Pair choose(Pair left, Pair right) {
            return left.ageDifference() > right.ageDifference() ? left : right;
        }
    };

    abstract Pair choose(Pair left, Pair right);
}

// public enum Criteria {
//
//     Closest((a, b) -> a.ageDifference() < b.ageDifference() ? a : b),
//     Furthest((a, b) -> a.ageDifference() > b.ageDifference() ? a : b);
//
//     private final Chooser chooser;
//
//     interface Chooser {
//         Pair choose(Pair left, Pair right);
//     }
//
//     Criteria(Chooser chooser) {
//         this.chooser = chooser;
//     }
//
//     Pair choose(Pair left, Pair right) {
//         return chooser.choose(left, right);
//     }
// }
