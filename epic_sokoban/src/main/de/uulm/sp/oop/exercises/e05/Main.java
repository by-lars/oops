package de.uulm.sp.oop.exercises.e05;

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

		ArrayList<String> adasdh = new ArrayList<>(); 
		
		int a = 5;
		int b = 6;
		Pair<Integer, Integer> pair = new Pair<>(a,b);


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
