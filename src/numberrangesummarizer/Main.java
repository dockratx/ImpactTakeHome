//@NabeelDockrat


package numberrangesummarizer;

import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Create instance of Summarizer class
        Summarizer summarizer = new Summarizer();

        //Loop to allow for multiple inputs
        while (true) {

            try {

                System.out.println("Enter input or type 'Quit' to exit: ");

                String input = scanner.nextLine();

                if (input.equals("Quit")) { System.exit(0); }

                //Sort input
                Collection<Integer> numbers = summarizer.collect(input);

                //Return comma delimited output
                System.out.println("Result: " + summarizer.summarizeCollection(numbers));

            }
            catch (Exception e){
                System.out.println("Please only enter integer values or Quit");
            }
        }
    }
}
