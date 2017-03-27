package algorithm;

public final class Pair {

    private final Person youngest;
    private final Person oldest;

    private Pair(Person youngest, Person oldest) {
        this.youngest = youngest;
        this.oldest = oldest;
    }

    static Pair fromUnordered(Person a, Person b) {
        return new Pair(a.youngest(b), a.oldest(b));
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

    public Boolean containsSamePerson() {
        return youngest == oldest;
    }
}
