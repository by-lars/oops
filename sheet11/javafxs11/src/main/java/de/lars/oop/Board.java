package de.lars.oop;

import java.util.Observable;

public class Board extends Observable {
        public void register(Student student) {
                addObserver(student);
        }

        public void changeMessage(String msg) {
                setChanged();
                notifyObservers(msg);
        }
}
