package lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {
	public String randomString() {
		
		String Alphabets = "abcdefghijklmnopqrstuvxyz";

		String result = "";
		for (int i = 0; i < 10; i++) {

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
	
	
//	public void updateProperties(String key, String value) throws Exception {
//		FileInputStream in = new FileInputStream("env.properties");
//		Properties props = new Properties();
//		props.load(in);
//		in.close();
//
//		FileOutputStream out = new FileOutputStream("env.properties");
//		props.setProperty(key,value);
//		props.store(out, null);
//		out.close();
//	}
}
