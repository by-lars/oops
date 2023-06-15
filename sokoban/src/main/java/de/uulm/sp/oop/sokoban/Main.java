package de.uulm.sp.oop.sokoban;

import de.uulm.sp.pvs.util.Sokoban;

import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		boolean shouldRun = true;
		Scanner scanner = new Scanner(System.in);

		var map = new char[11][];
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

		while(shouldRun) {
			System.out.println(Sokoban.sokobanToString(map));
			System.out.println("Where do you want to go? (w/a/s/d or q to quit)");

			var input = scanner.nextLine().toLowerCase(Locale.ROOT);

			if(input.equals("q")) {
				shouldRun = false;
				return;
			}


			switch (input) {
				case "w":
					Sokoban.move(map, Sokoban.DIRECTION.NORTH);
					break;
				case "a":
					Sokoban.move(map, Sokoban.DIRECTION.WEST);
					break;
				case "s":
					Sokoban.move(map, Sokoban.DIRECTION.SOUTH);
					break;
				case "d":
					Sokoban.move(map, Sokoban.DIRECTION.EAST);
					break;
			}

		}
	}
}
