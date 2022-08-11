package lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {
	
	public static void hold(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String randomString() {
		return randomString(5);
	}
	public String randomString(int n) {
		
		String Alphabets = "abcdefghijklmnopqrstuvxyz";

		String result = "";
		for (int i = 0; i < n; i++) {

			int index = (int) (Alphabets.length() * Math.random());

			result += Alphabets.charAt(index);
		}
		
		return result;
		}
	
	public  InputStream getResourceAsIS(String fileName){
		try {
			return this.getClass().getClassLoader().getResourceAsStream(fileName);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public  String getResourcePath(String fileName){
		String path = "";
		try {
			 path =  this.getClass().getClassLoader().getResource(fileName).getPath();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
	
}
