package hrm.com.utils;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadData {
public static String getData(String filename, String key) throws IOException {
	String filepath=".//resources//"+filename+".properties";
			//C:\Users\Lenovo\eclipse-workspace\HRM-->.
	FileInputStream instream=new FileInputStream(filepath);
	Properties pro=new Properties();
	pro.load(instream);
    String data=pro.getProperty(key);
    return data;

}
}

