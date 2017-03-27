package algorithm;

public final class Pair {

    private final Person youngest;
    private final Person oldest;

    private Pair(Person youngest, Person oldest) {
        this.youngest = youngest;
        this.oldest = oldest;
    }

    static Pair fromPair(Person left, Person right) {
        return new Pair(left.youngest(right), left.oldest(right));
    }

    public Person youngest() {
        return youngest;
    }

    public Person oldest() {
        return oldest;
    }

    long ageDifference() {
        return oldest.birthDate().getTime() - youngest.birthDate().getTime();
    }
}
