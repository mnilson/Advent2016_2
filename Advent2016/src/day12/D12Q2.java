package day12;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class D12Q2 {

	public static Set<Pair> pairs = new HashSet<Pair>();

	public static void main(String[] args) throws IOException {
		int max = 45;
		int targetX = 31;
		int targetY = 39;
		int magicNumber = 1358;
		char[][] map = new char[max][max];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (i == targetX && j == targetY) {
					map[j][i] = 'X';
				} else if (i == 1 && j == 1) {
					map[j][i] = ' ';
				} else if (isWall(i, j, magicNumber, map))
					map[j][i] = '#';
				else
					map[j][i] = ' ';
			}
		}
		pairs.add(new Pair(1,1));
		traverseMap(map, 1, 1, 1);
		printMap(map);
		
		
		for(Pair p : pairs){
			System.out.println(p.x + " " + p.y);
		}
	
		paintMap(map);
		printMap(map);
		
		System.out.println("Num Pairs: " +pairs.size());
	}

	private static void paintMap(char[][] map) {
		for(Pair p : pairs){
			map[p.x][p.y] = 'P';
		}
	}

	private static char[][] traverseMap(char[][] map, int x, int y, int count) {
		if (count > 50) {
			return map;
		}

		System.out.println(count + " " + x + "," + y);
		System.out.println("Trying Down?");
		int newX = x+1;
		int newY = y;
		if (newX < map.length && map[newX][newY] == ' ') {
			System.out.println("Going Down " + map[newX][newY]);
			// can move Down
			char[][] input = map.clone();
			input[newX][newY] = ((count%10)+"").charAt(0);
			pairs.add(new Pair(newX, newY));
			traverseMap(input, newX, newY, count+1);
			map[newX][newY]= ' ';
		}
		
		System.out.println("Trying Right?");
		newX = x;
		newY = y+1;
		if (newY < map.length && map[newX][newY] == ' ') {
			System.out.println(x + "," + y + ": Right " + map[newX][newY]);
			// can move Right
			char[][] input = map.clone();
			input[newX][newY]  = ((count%10)+"").charAt(0);
			pairs.add(new Pair(newX, newY));
			traverseMap(input, newX, newY, count+1);
			map[newX][newY]= ' ';			
		}
		
		System.out.println("Trying Up?");
		newX = x-1;
		newY = y;
		if (newX >= 0 && map[newX][newY] == ' ') {
			// can move Up
			System.out.println(x + "," + y + ": Up " + map[newX][newY]);
			char[][] input = map.clone();
			input[newX][newY]  = ((count%10)+"").charAt(0);
			pairs.add(new Pair(newX, newY));
			traverseMap(input, newX, newY, count+1);
			map[newX][newY]= ' ';
		}
		
		
		System.out.println("Trying Down?");
		newX = x;
		newY = y-1;
		if (newY >= 0 && map[newX][newY] == ' ') {
			// can move Left
			System.out.println(x + "," + y + ": Left " + map[newX][newY]);
			char[][] input = map.clone();
			input[newX][newY]  = ((count%10)+"").charAt(0);
			pairs.add(new Pair(newX, newY));
			traverseMap(input, newX, newY, count+1);
			map[newX][newY]= ' ';
		}
		System.out.println("pop " + count + " " + x + "," + y);
		return null;
	}

	private static boolean isWall(int x, int y, Integer magicNumber,
			char[][] map) {
		long val = (x * x) + (3 * x) + (2 * x * y) + y + (y * y);
		val += magicNumber;
		String bits = BigInteger.valueOf(val).toString(2);
		int count = 0;
		while (bits.contains("1")) {
			bits = bits.replaceFirst("1", "");
			count++;
		}
		return !(count % 2 == 0);
	}

	private static void printMap(char[][] map) {
		// print header.
		String h1 = "   ", h2 = "   ";
		for (int h = 0; h < map.length; h++) {
			if (h % 10 != 0) {
				h1 += " ";
			} else {
				h1 += (h + "").charAt(0);
			}
			h2 += h % 10;
		}
		h1 = "";
		h2 = "";
		System.out.println(h1);
		System.out.println(h2);
		for (int i = 0; i < map.length; i++) {
			// System.out.print(String.format("%1$02d ", i));
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
