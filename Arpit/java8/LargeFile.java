package java8;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class LargeFile {
	private static final String FILE_HEADER = "TimeStamp,Ticker,CurrFrom,CurrTo,ExchangeRate";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String COMMA_DELIMITER = ",";
	
	static final Pattern pattern = Pattern.compile("\\s");
	
	String getNthColumn(String line, int columnIndex, int columnSize){
		return pattern.split(line, columnSize)[columnIndex];
	}
	
	public static void main(String[] args) throws IOException {
		
		FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter("C://Users//aver51//Desktop//examples//ticker.csv");

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			Date date = new Date();
			Double random = null;
			
			List<String> tickerList = new ArrayList<String>();
			tickerList.add("EUR/USD");
			tickerList.add("EUR/GBP");
			tickerList.add("INR/USD");
			tickerList.add("EUR/USD");
			
			for (int i=0; i<4000000; i++) {
				String tickers = tickerList.get(new Random().nextInt(tickerList.size()));
				random = Math.random();
				fileWriter.append(date.toString());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(tickers);
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(tickers.split("/")[0]);
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(tickers.split("/")[1]);
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(random.toString());
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			System.out.println("CSV file was created successfully !!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
				fileWriter.flush();
				fileWriter.close();
		}
		
		try(Stream<String> lines = Files.lines(Paths.get("C://Users//aver51//Desktop//examples//ticker.csv"), StandardCharsets.UTF_8)){
			lines.forEach(System.out::println);
		}
	}

}
