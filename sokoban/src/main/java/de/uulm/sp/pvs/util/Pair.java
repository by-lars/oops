package de.uulm.sp.pvs.util;

import java.util.Objects;

public class Pair<F extends Comparable<F>, S extends Comparable<S>> implements Comparable<Pair<F,S>>{
    private final F first;
    private final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public int compareTo(Pair<F, S> o) {
        int cf = o.first.compareTo(this.first);
        int cs = o.second.compareTo(this.second);

        return cf != 0 ? cf : cs;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}