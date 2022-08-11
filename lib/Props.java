package lib;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Props {
	Properties p;
	InputStream in;
	FileOutputStream out;
	String path;
	String fileName;
	Util util;

	public Props(String fileName) {
		try {
			this.fileName = fileName;
			p = new Properties();
			util = new Util();
			in = util.getResourceAsIS(fileName);
			p.load(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String get(String key) {
		
		return p.get(key).toString();
	}

	public void set(String key, String value) {
		p.setProperty(key, value);
		try {
			path = util.getResourcePath(fileName);
			out = new FileOutputStream(path);
			p.store(out, null);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
