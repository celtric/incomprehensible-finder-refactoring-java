package algorithm;

public enum Criteria {
    Closest {
        @Override
        Pair choose(Pair a, Pair b) {
            return a.closest(b);
        }
    },

    Furthest {
        @Override
        Pair choose(Pair a, Pair b) {
            return a.furthest(b);
        }
    };

    abstract Pair choose(Pair a, Pair b);
}

// public enum Criteria {
//     Closest {
//         @Override
//         Pair choose(Pair a, Pair b) {
//             return a.ageDifference() < b.ageDifference() ? a : b;
//         }
//     },
//
//     Furthest {
//         @Override
//         Pair choose(Pair a, Pair b) {
//             return a.ageDifference() > b.ageDifference() ? a : b;
//         }
//     };
//
//     abstract Pair choose(Pair a, Pair b);
// }

// public enum Criteria {
//
//     Closest((a, b) -> a.ageDifference() < b.ageDifference() ? a : b),
//     Furthest((a, b) -> a.ageDifference() > b.ageDifference() ? a : b);
//
//     private final Chooser chooser;
//
//     interface Chooser {
//         Pair choose(Pair a, Pair b);
//     }
//
//     Criteria(Chooser chooser) {
//         this.chooser = chooser;
//     }
//
//     Pair choose(Pair a, Pair b) {
//         return chooser.choose(a, b);
//     }
// }
