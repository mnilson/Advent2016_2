package day5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class D5Q1 {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String roomId = "reyedfim";
		String answer = "";
		int ix = 0;
		while (answer.length() < 8){
			String in = roomId + ix++;
			byte[]out = MessageDigest.getInstance("MD5").digest(in.getBytes());
			String hash = String.format("%02x", out[0]) + String.format("%02x", out[1]) +String.format("%02x", out[2]);
			if(hash.substring(0,5).equals("00000")){
				answer += hash.substring(5);
			}

		}
		
		System.out.println("Answer: " + answer);

	}

}
