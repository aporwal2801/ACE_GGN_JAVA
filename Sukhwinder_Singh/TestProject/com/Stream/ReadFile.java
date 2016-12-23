package com.Stream;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {
	
	public static void main(String[] args) {
		streamRead("D:\\tempSpring\\csvtemp.txt");
//		streamRead("D:\\tempSpring\\temp.txt");
	}
	public static Function<String, FileData> mapToData = (line) -> {
		  String[] p = line.split(", ");
		  return new FileData(p[0], Integer.parseInt(p[1]));
		};
		
		static Comparator<FileData> byPrice = 
				  (p1, p2) -> p2.getPrice() - p1.getPrice();
	 static void streamRead(String fname){
		 
		 try {
			 
			 //skip// max(fun)  //limit(10)
			 BufferedReader reader = Files.newBufferedReader(Paths.get(fname));
			 List<String> lines= reader.lines().collect(Collectors.toList());
//			 Stream<String> lines= Files.lines(Paths.get(fname)); 
			//lines.flatMap(line -> Arrays.stream(line.split(" ")).distinct()).forEach(el -> System.out.print("_" +el));
//			 List<String> columns = lines.stream().findFirst()
//		                .map((line) -> Arrays.asList(line.split(" ,")))
//		                .get();
//			 Optional<FileData> a=lines.stream().skip(1).map(mapToData).;
			 List<FileData> persons =lines.stream().skip(1).map(mapToData).sorted(byPrice).limit(2).collect(Collectors.toList());
System.out.println() 
			  ;
//			 
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	 }

}

class FileData {
	 public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	String ticker; 
	 int price;
	 
	 public FileData() {
		// TODO Auto-generated constructor stub
	}
	 public FileData(String a , int b ) {
			this.ticker=a;
			this.price = b;
		}
}
