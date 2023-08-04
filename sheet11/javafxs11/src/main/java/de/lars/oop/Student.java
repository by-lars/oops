package de.lars.oop;

import java.util.Observable;
import java.util.Observer;

public class Student implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Changed: " + (String)arg);
    }
}
