package algorithm;

public final class Pair {

    private final Person youngest;
    private final Person oldest;

    private Pair(Person youngest, Person oldest) {
        this.youngest = youngest;
        this.oldest = oldest;
    }

    static Pair fromUnordered(Person a, Person b) {
        return new Pair(Person.youngest(a, b), Person.oldest(a, b));
    }

    public Person youngest() {
        return youngest;
    }

    public Person oldest() {
        return oldest;
    }

    static Pair closest(Pair a, Pair b) {
        return a.ageDifference() < b.ageDifference() ? a : b;
    }

    static Pair furthest(Pair a, Pair b) {
        return a.ageDifference() > b.ageDifference() ? a : b;
    }

    private long ageDifference() {
        return oldest.ageDifference(youngest);
    }

    Boolean containsDifferentPeople() {
        return youngest != oldest;
    }
}
