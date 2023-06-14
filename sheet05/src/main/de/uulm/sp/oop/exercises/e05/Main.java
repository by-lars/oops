package de.uulm.sp.oop.exercises.e05;

/*
 * Aufgabe 2
 * a) Listen können sortiert werden, wenn die Elemente das Comparable Interface implementieren
 * 	  Eine Collection kann auch ein ungeordnete Datenstruktur sein, wie etwa ein Set. Somit können Collection im allegemeinen nicht sortiert werden
 *
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

import static java.awt.event.KeyEvent.*;

public class Main extends JPanel implements KeyListener {

	public static void main(String[] args) {
		// Implement Task 2
		var epicList = new ArrayList<Pair<String, Integer>>();
		epicList.add(new Pair<>("B", 2));
		epicList.add(new Pair<>("C", 3));
		epicList.add(new Pair<>("F", 5));
		epicList.add(new Pair<>("A", 1));
		epicList.add(new Pair<>("D", 4));
		epicList.add(new Pair<>("B", 2));
		epicList.add(new Pair<>("F", 5));

		Collections.sort(epicList);
		System.out.println(epicList);

		var hashSet = new HashSet<Pair<String, Integer>>();
		for(var entry : epicList) {
			if(hashSet.contains(entry))
				System.out.println("Hashset already contains: " + entry);

			hashSet.add(entry);
		}

		// Implement Task 3
		var now = LocalDate.now();
		var oneMonthAgo = now.minus(1, ChronoUnit.MONTHS);
		var fourWeeksAgo = now.minus(4, ChronoUnit.WEEKS);

		System.out.println(now);
		System.out.println("One Month Ago:" + oneMonthAgo + " (" + oneMonthAgo.getDayOfWeek() + ")"); // Ne sind ned gleich
		System.out.println("Four Weeks Ago: " + fourWeeksAgo + " (" + fourWeeksAgo.getDayOfWeek() + ")");

		// Implement Task 4
		Main sokobanGui = new Main();
	}

	private JFrame frame;
	private JTextArea textArea;
	private char[][] map;

	public Main() {
		map = new char[11][];
		map[0] =  "#######".toCharArray();
		map[1] =  "#.....#".toCharArray();
		map[2] =  "#..$..#".toCharArray();
		map[3] =  "#.$@$.#".toCharArray();
		map[4] =  "#..$..#".toCharArray();
		map[5] =  "#.....#".toCharArray();
		map[6] =  "#..####".toCharArray();
		map[7] =  "#.$####".toCharArray();
		map[8] =  "#.....#".toCharArray();
		map[9] =  "#.....#".toCharArray();
		map[10] = "#######".toCharArray();



		frame = new JFrame("Sokoban");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);

		textArea = new JTextArea();
		textArea.setText(Sokoban.sokobanToString(map));
		textArea.setEditable(false);
		textArea.setCursor(null);
		textArea.setOpaque(false);
		textArea.setFocusable(false);
		textArea.setFont(new Font("Courier", Font.PLAIN, 26));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea);

		frame.addKeyListener(this);

		frame.setResizable(false);
		frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case VK_RIGHT:
				Sokoban.move(map, Sokoban.DIRECTION.EAST);
				break;
			case VK_LEFT:
				Sokoban.move(map, Sokoban.DIRECTION.WEST);
				break;
			case VK_UP:
				Sokoban.move(map, Sokoban.DIRECTION.NORTH);
				break;
			case VK_DOWN:
				Sokoban.move(map, Sokoban.DIRECTION.SOUTH);
				break;
		}

		textArea.setText(Sokoban.sokobanToString(map));
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
