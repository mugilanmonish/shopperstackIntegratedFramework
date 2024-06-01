package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		//
	}
}
