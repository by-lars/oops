package java.de.uulm.sp.oop.exercises.e05;

/*
 * Aufgabe 2
 * a) Listen können sortiert werden, wenn die Elemente das Comparable Interface implementieren
 * 	  Eine Collection kann auch ein ungeordnete Datenstruktur sein, wie etwa ein Set. Somit können Collection im allegemeinen nicht sortiert werden
 *
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;

public class Main {

	public static void main(String[] args) {
		// Implement Task 2
		var epicList = new ArrayList<Pair<String, Integer>>();
		epicList.add(new Pair<>("C", 3));
		epicList.add(new Pair<>("F", 5));
		epicList.add(new Pair<>("A", 1));
		epicList.add(new Pair<>("D", 4));
		epicList.add(new Pair<>("B", 2));

		Collections.sort(epicList);

		System.out.println(epicList);



		// Implement Task 3
		
		// Implement Task 4

	}

}
