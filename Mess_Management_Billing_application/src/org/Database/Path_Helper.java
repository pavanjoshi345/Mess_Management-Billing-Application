package org.Database;

import java.io.File;
import java.util.*;
import java.io.*;
public class Path_Helper {

	static Properties p = new Properties();
	static {
		File f = new File(".");
		String filePath = f.getAbsolutePath();
		String mainPath = filePath.substring(0, filePath.length()-1)
				+ "src\\org\\Database\\DB.properties";
		
	    
		FileInputStream fine = null;
		try {
			fine = new FileInputStream(mainPath);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			p.load(fine);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
