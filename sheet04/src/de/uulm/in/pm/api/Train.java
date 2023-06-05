package de.uulm.in.pm.api;

public class Train {
    public enum Engine {
        ELECTRIC,
        DIESEL
    }

    public int model;
    public Engine engine;
    public int ps;
    public int maxSpeedy;

    public Wagon wagon;

    public Train() {
        this.model = 42069;
        this.engine = Engine.ELECTRIC;
        this.ps = 1;
        this.maxSpeedy = 9000;
        this.wagon = null;
    }

    public Train(int model, Engine engine, int ps, int maxSpeedy, Wagon wagon) {
        this.model = model;
        this.engine = engine;
        this.ps = ps;
        this.maxSpeedy = maxSpeedy;
        this.wagon = wagon;
    }

    public int totalSeatCount() {
        int count = 0;
        Wagon w = wagon;

        while(w != null) {
            count += w.seats;
            w = w.next;
        }

        return count;
    }

    public void setLight(boolean on) {
        Wagon w = wagon;

        while(w != null) {
            w.isLightOn = on;
            w = w.next;
        }
    }

    @Override
    public String toString() {
        return "Train " + model + " " + engine + " " + ps + "PS vMax=" + maxSpeedy + "km/h Total Seats: " + totalSeatCount() + "\n   " + wagon;
    }
}
