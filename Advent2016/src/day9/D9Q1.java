package day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D9Q1 {
	private static int height = 6;
	private static int width = 50;

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		boolean fast = false;
		URL url = ClassLoader.getSystemClassLoader().getResource(
				"day9/input.txt");
		BufferedReader br = new BufferedReader(new FileReader(url.getFile()));

		String arg = br.readLine();
		while (arg != null) {
			System.out.println(arg);

			int length = 0;
			String result = "";
			boolean inBrackets = false;
			for (int i = 0; i < arg.length(); i++) {
				char c = arg.charAt(i);				
				if (c == '(') {
					int end = arg.indexOf(')',i);
					String bracket = arg.substring(i+1,end);

					StringTokenizer st = new StringTokenizer(bracket,"x");
					int num = Integer.parseInt(st.nextToken());
					int mult = Integer.parseInt(st.nextToken());
					boolean done = false;
					int count = 0;
					int ix = end +1;
					String toMultiply = "";
					if(ix + num > arg.length()){
						num = arg.length()-ix-1;
					}
					toMultiply = arg.substring(ix, num+ix);
					System.out.println("To Mult: " + toMultiply);
//					while(!done){
//						if(arg.charAt(ix)=='('){
//							// get the full bracket
//							toMultiply += arg.substring(ix, arg.indexOf(")", ix)+1);
//							ix = arg.indexOf(")", ix);
//						}else{
//							toMultiply += arg.charAt(ix);
//							count++;
//						}
//						ix++;
//						System.out.println(arg + " " + ix + " " + toMultiply);
//						done = count == num || ix >= arg.length();
//							
//					}
					while (mult > 0){
						result += toMultiply;
						mult --;
					}
					i = end+toMultiply.length();
				}else{
					result += c;
				}
			}

			System.out.println("Result: " + result.length());
			
			if (!fast) {
				//String in = scan.nextLine();
//				if (in != null && in.equalsIgnoreCase("go")) {
//					fast = true;
//				}
			}
			arg = br.readLine();

		}
		br.close();

	}
}
