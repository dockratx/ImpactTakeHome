//@NabeelDockrat

package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Summarizer implements NumberRangeSummarizer {

    @Override
    /**
     * Converts String input into a list of component digits sorted in ascending order.
     */
    public Collection<Integer> collect(String input) {

        ArrayList<Integer> sortedInput = new ArrayList<>();
        String[] tokens = input.split(",");

        for (String token: tokens){
            sortedInput.add(Integer.parseInt(token));
        }

        //Sort list of Integers in ascending order
        Collections.sort(sortedInput);

        return sortedInput;
    }

    @Override
    /**
     * Produces a comma delimited list of numbers, grouping the numbers into a range when they are sequential.
     */
    public String summarizeCollection(Collection<Integer> input) {

        ArrayList<Integer> sortedInput = (ArrayList<Integer>)input;
        String output = "";

        //Loop through each index of the digit list
        for (int i = 0; i < sortedInput.size(); i++){

            int x = sortedInput.get(i);
            int secondDigit = x;
            int prevDigit = x;
            int followingDigitIndex = i + 1;

            //Identify whether or not this is a range case or single digit case
            while (followingDigitIndex < sortedInput.size()){

                if (sortedInput.get(followingDigitIndex) != prevDigit + 1) {

                    //Break loop if following digit isn't sequential
                    break;
                }
                else{

                    //Update upper bound of range
                    secondDigit = sortedInput.get(followingDigitIndex);
                    prevDigit++;
                }
                followingDigitIndex++;
            }

            //If x != secondDigit, a rangeCase is concatenated to the output result.
            if (x == secondDigit){
                if (output.isEmpty()){ output = Integer.toString(x); }
                else{ output = output + ", " + x; }
            }
            else{
                if (output.isEmpty()){ output =  x + "-" + secondDigit; }
                else{ output = output + ", " + x + "-" + secondDigit; }

                //Skip index if range case
                i = followingDigitIndex-1;
            }
        }
        return output;
    }
}

