package com.SerializableTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;


public class Demo_D implements Serializable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo d = null;
		 try {
	         FileInputStream fileIn = new FileInputStream("D:\\tempSpring\\temp.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         d = (Demo) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i) {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
		 System.out.println(d.name);
		 System.out.println(d.sname);
	}

}
