package java8;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String args[]) throws IOException {
		String fileName = "C://Users//aver51//Desktop//examples//file.txt";
		streamRead(fileName);
	}

	private static void streamRead(String fileName) throws IOException {

		Path path = Paths.get(fileName);
		
		try(Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)){
			lines.forEach(System.out::println);
		}
		
		
		long total = Files
				.lines(Paths.get(fileName), StandardCharsets.UTF_8)
				.flatMap(line -> Arrays.stream(line.split(" "))).distinct()
				.count();
		System.out.println("Total value : " + total);

		System.out.println(Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)
				.map(line -> Arrays.stream(line.split(" "))).distinct()
				.count()); 
	}
}
