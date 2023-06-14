package de.uulm.sp.oop.exercises.e05;

public class Point extends Pair<Integer, Integer> {
    public Point(Integer x, Integer y) {
        super(x, y);
    }

    Integer getX() {
        return getFirst();
    }

    Integer getY() {
        return getSecond();
    }
}
