package de.uulm.in.pm.api;

public class Wagon {
    public Wagon() {
        this.freeSeats = 69;
        this.reservedSeats = 420;
        this.seats = freeSeats + reservedSeats;
        this.wagonClass = Class.SECOND;
        this.isDouble = true;
        this.next = null;
        this.toiletState = Math.random() < 0.3 ? ToiletState.UNUSABLE : ToiletState.FREE;
        this.isLightOn = (Math.random() > 0.5);
    }

    public Wagon(int seats, int reservedSeats, int freeSeats, Class wagonClass, boolean isDouble, Wagon next) {
        this.freeSeats = freeSeats;
        this.reservedSeats = reservedSeats;
        this.seats = seats;
        this.wagonClass = wagonClass;
        this.isDouble = isDouble;
        this.next = next;
        this.toiletState = Math.random() < 0.3 ? ToiletState.UNUSABLE : ToiletState.FREE;
        this.isLightOn = (Math.random() > 0.5);

        if(seats < freeSeats + reservedSeats) {
            throw new RuntimeException("Less total seats than freeSeats + reservedSeats");
        }
    }

    public enum Class {
        FIRST,
        SECOND
    }

    public enum ToiletState {
        FREE,
        OCCUPIED,
        UNUSABLE
    }

    @Override
    public String toString() {
        return "(" + seats + "/" + reservedSeats + "/" + freeSeats + ") " + wagonClass + " Class Toilet: " + toiletState + " \n   " + (next == null ? "" : next);
    }

    public int freeSeats;
    public int reservedSeats;
    public int seats;

    public Class wagonClass;
    public ToiletState toiletState;
    public boolean isDouble;

    public boolean isLightOn;

    public Wagon next;
}
