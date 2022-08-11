import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import lib.Util;

public class envTest {
	
	public static void set(String key, String value) throws Exception {
		
//		Util util = new Util();
//		String path = util.getResourcePath("env.properties");
//		
		FileInputStream in = new FileInputStream("F:\\SeleniumTest\\src\\main\\resources\\env.properties");
		Properties props = new Properties();
		props.load(in);
		in.close();
		
		System.out.println(props.get("email"));

		FileOutputStream out = new FileOutputStream("F:\\SeleniumTest\\src\\main\\resources\\env.properties");
		props.setProperty(key,value);
		props.store(out, null);
		out.close();
		System.out.println(props.get("email"));
	}

	public static void main(String[] args) {
	
		try {
			set("email","salamaddin2@gmail.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
