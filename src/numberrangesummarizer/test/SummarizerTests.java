package numberrangesummarizer.test;
import numberrangesummarizer.Summarizer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;


public class SummarizerTests {
    Summarizer summarizer = new Summarizer();

    @Test
    /**
     * Assumption: Input contains no repeated digits. Input may be unordered.
     */
    public void collect_whenUnordered(){
        String input = "4,3,2,1";
        ArrayList<Integer> expectedResult = new ArrayList<>();

        Collection<Integer> actualResult = summarizer.collect(input);
        for (int i = 1; i < 5; i++){
            expectedResult.add(i);
        }

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void summarizeCollection_whenFirstSpotIsRangeCase(){

        ArrayList<Integer> input = new ArrayList<>();
        String expectedResult = "1-4";

        for (int i = 1; i < 5; i++){
            input.add(i);
        }

        String actualResult = summarizer.summarizeCollection(input);

        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test
    public void summarizeCollection_whenLasttSpotIsRangeCase(){

        ArrayList<Integer> input = new ArrayList<>();
        String expectedResult = "1, 3-4";

        for (int i = 1; i < 5; i++){
            if (i==2){continue;}
            input.add(i);
        }

        String actualResult = summarizer.summarizeCollection(input);

        Assert.assertEquals(actualResult,expectedResult);

    }
}
