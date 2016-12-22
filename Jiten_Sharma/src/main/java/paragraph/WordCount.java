package paragraph;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 12/19/16
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class WordCount {
    public static void main(String[] args) throws IOException {
        File file = new File("c:\\paragraph.txt");
        List<String> lines = FileUtils.readLines(file);
        System.out.println("number of lines:"+lines.size());

        //now store all words in map with counts
        Map<String, Integer> map = new TreeMap<>();

        for(String line : lines){
           String[] words = line.split(" ");//split line by space
            for (String word : words){
                word = word.trim();
                Integer count = map.get(word);
                if(count != null ){
                    //word already there
                    count++;
                }else{
                    count=1;
                }
                map.put(word, count);
            }
        }
        System.out.println("map size:"+map.size());

        //now provide list
        Set<String> set = map.keySet();
        System.out.println(set); //it should be natural order
        System.out.println(map);

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String input = scanner.nextLine();
            for (String match : set){
               if(match.startsWith(input)){
                   System.out.println("match:"+match);
               }
            }
        }
    }
}
