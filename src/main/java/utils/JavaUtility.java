package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
	}
	
	public String getSystemDate() {
		Date dt = new Date();
		String date = dt.toString();
		return date;
	}
	
	public String getSystemDateInFormat() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt = new Date();
		String sysDateInFormat = dateFormat.format(dt);
		return sysDateInFormat;
	}
	
	public String uniqueEmail(String mail) {
		Random ran = new Random();
		int random = ran.nextInt(1000);
		String[] s = mail.split("@");
		return(s[0]+random+"@"+s[1]);
	}
	
	/**
	 * @author Mugilan
	 * @return int
	 * This method remove special Characters and convert string number to integer
	 */
	public int stringToInt(String s) {
		return Integer.parseInt(s.replace("₹", ""));
	}
	
	/**
	 * @author Mugilan
	 * @param key
	 * @param value
	 * This method is used insert one value in linkedhashmap it accepts string. 
	 */
	
	public Map<String, String> insertValueIntoMap(String key, String value) {
		Map<String, String> lhmap = new LinkedHashMap<String, String>();
		lhmap.put(key, value);
		return lhmap;
	}
	
	public  String[] splitUsingDoubleSpace(String s) {
		String[] str = s.split("  ");
		return str;
	}
	
	public boolean compareTwoObjects(Object obj1, Object obj2) {
		if(obj1.equals(obj2)) 
			return true;
		else {
			return false;
		}
	}
}
