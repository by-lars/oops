package main.java.de.uulm.sp.oop.exercises.e05;

/*
 * Aufgabe 1
 * a)
 *  - final class
 *  - alle fields als private markieren
 *  - keine setter methoden implementieren
 *  - alle mutable fields als final markieren
 *  - alle fields im constructor mit einer deep-copy initialisieren
 *  - im getter nur eine kopie vom field zurück geben
 *
 * b) Man kann sicher stellen, dass der gespeicherte Wert nicht verändert wird.
 * c) Man kann im Konstructor nur eine shallow-copy durchführen, somit wird den Variabeln first und second eine reference, zu den Objekten welche zur initalisierung dieser Varaibeln genutzt wurden, übergebn.
 *    Außerdem kann man bei den gettern auch keine kopie von den Variabeln erstellen
 */

import java.util.Objects;

final class Pair<F extends Comparable<F>, S extends Comparable<S>> implements Comparable<Pair<F,S>>{
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
}