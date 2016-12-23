package com.SerializableTest;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Demo implements Serializable{

	String name = "ABC";
	static String sname ="2";
	
	public static void main(String[] args) throws IOException {
			
		Demo d = new Demo();
		FileOutputStream fileOut =
		         new FileOutputStream("D:\\tempSpring\\temp.txt");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(d);
		         out.close();
		         fileOut.close();
		         System.out.printf("Serialized data is saved in /tmp/employee.ser");
		         
		         d.sname="5";
	}
}
