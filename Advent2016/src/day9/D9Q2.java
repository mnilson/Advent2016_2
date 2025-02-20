package day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D9Q2 {
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

			BigInteger result = decompress(arg);

			System.out.println("Result: " + result);
			
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

	private static BigInteger decompress(String arg) {
		BigInteger result = BigInteger.ZERO;
		for (int i = 0; i < arg.length(); i++) {
			char c = arg.charAt(i);				
			if (c == '(') {
				int end = arg.indexOf(')',i);
				String bracket = arg.substring(i+1,end);

				StringTokenizer st = new StringTokenizer(bracket,"x");
				int num = Integer.parseInt(st.nextToken());
				int val = Integer.valueOf(st.nextToken());
				BigInteger mult = BigInteger.valueOf(val);
				int ix = end +1;
				String toMultiply = "";
				if(ix + num > arg.length()){
					num = arg.length()-ix-1;
				}
				toMultiply = arg.substring(ix, num+ix);
//				System.out.println(i + " " + (end+toMultiply.length()) + " " + arg + " " + toMultiply);
				i = end+toMultiply.length();
				BigInteger len = decompress(toMultiply);
				BigInteger old = result;
				BigInteger toAdd = mult.multiply(len);
				result = result.add(toAdd);
//				if(old > result){
//					System.err.println("#Old: " + old + " Res: " + result + " M: "+ mult + " L:" + len + " toAdd:" + toAdd);
//				}
				
				
			}else{
//				int old = result;
				result=result.add(BigInteger.ONE);
//				if(old > result){
//					System.err.println("*Old: " + old + " Res: " + result);
//				}
			}
		}
//		System.out.println(arg + " " + );
		return result;
	}
}
