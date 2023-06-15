package de.uulm.sp.pvs.util;

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
