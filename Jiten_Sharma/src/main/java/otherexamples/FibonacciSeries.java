package otherexamples;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 11/20/16
 * Time: 6:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class FibonacciSeries {
    public static void main(String[] args) {
        Series series = new Series(1,100);
        series.printSeries();

    }
}

class Series{
    private int start;
    private int totalNumberToBePrinted;
       public Series(int start, int totalNumberToBePrinted){
           this.start = start;
           this.totalNumberToBePrinted=totalNumberToBePrinted;
       }

    public void printSeries(){
        System.out.println("printing numbers from "+start);
        int firstNumber = start;
        int secondNumber = start;

        for (int i=start; i < totalNumberToBePrinted; i++){

            int seriesNumber = firstNumber+secondNumber;
            System.out.println(seriesNumber);
            firstNumber = secondNumber;
            secondNumber = seriesNumber;

        }

    }
 }
