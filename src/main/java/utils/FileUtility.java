package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	/*
	 * This method is used to read data from property file
	 * param key
	 * return
	 * throws IOException
	*/
	
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.FilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
}