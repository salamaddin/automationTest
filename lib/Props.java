package lib;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Props {
	Properties p;

	public Props(String fileName) {
		try {
			p = new Properties();
			Util util = new Util();
			p.load(util.getResourceAsIS(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String get(String key) {
		return p.get(key).toString();
	}
	
	public void updateProperties(String key, String value) {
		p.setProperty(key,value);
	}
}
