package day6;

public class D6Q2 {

	/**
	 * @param args
	 */
	private static int width = 8;
	public static void main(String[] args) {
		int[][] grid = new int[width][26];

		for (String arg : args) {
			char[] chars = arg.toCharArray();
			for (int ix = 0; ix < chars.length; ix++) {
				int cix = Character.getNumericValue(chars[ix])-10;
				int temp = grid[ix][cix];
				System.out.println("Temp: " + temp + " ix=" + ix + " cix=" + cix);
				temp++;
				grid[ix][cix] = temp;
			}
		}
		
		for(int i = 0; i < width; i++){
			int min = 0;
			int maxCol = 0;
			for(int j = 0; j < 26; j++){
//				System.out.println(i+","+j+ " " + grid[i][j]);
				if(grid[i][j] == 0){
					continue;
				}
				if(grid[i][j]<min || min == 0){
					min = grid[i][j];
					maxCol=j;
				}
			}
			Character res = Character.forDigit(maxCol+10, 36);
			System.out.println("MaxCol=" + res + " value="+min);
		}

	}

}
