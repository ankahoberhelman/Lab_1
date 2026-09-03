package assignment1;

/** Student-written tests for Problem 2. Add your own test cases below. */
public class Problem2Tester {
    public static void main(String[] args) {
        //already points out issue with puncuation
        String input = "The wicked wizard`s wily wraith garnishes his master`s pasta with garlic.";
        String expected = "wizard`s" + System.lineSeparator()
                + "garnishes" + System.lineSeparator();

        TestSupport.checkEquals(expected,
                Problem2.findDollarWords(input),
                "Incorrectly assumed end of word by punctuation rather than whitespace");
        //Replicates issue with not outputting words in the same case as they were inputted
        input = "GARNISHES, Garnishes, garnishes, GaRnIsHeS";
        expected = "GARNISHES," + System.lineSeparator()
                + "Garnishes," + System.lineSeparator()
                + "garnishes," + System.lineSeparator()
                + "GaRnIsHeS" + System.lineSeparator();
        TestSupport.checkEquals(expected,
                Problem2.findDollarWords(input),
                "Uppercase and lowercase should be replicated in output");
        
        //Shows that punctuation in the middle of a word is not handled correctly
        input = "garn'ishes, 'garnishes, garnishes'";
        expected = "garn'ishes," + System.lineSeparator()
                + "'garnishes," + System.lineSeparator()
                + "garnishes'" + System.lineSeparator();
        TestSupport.checkEquals(expected,
                Problem2.findDollarWords(input),
                "Incorrectly handled punctuation in the beginning, middle and end of words");
        
        // Shows that multiple matches in one input are printed correctly and identified
        input = "The wizard's (wizards) garlic pasta has garnishes that are magic";
        expected = "wizard's" + System.lineSeparator()
                + "(wizards)" + System.lineSeparator()
                + "garnishes" + System.lineSeparator();
        TestSupport.checkEquals(expected,
                Problem2.findDollarWords(input),
                "Multiple matches in one input");
        
        //Leading, trailing, and extra whitespace between words should be ignored and not affect the output    
        input = " The  wizard's  garlic      pasta  has  garnishes       that  are  magic ";
        expected = "wizard's" + System.lineSeparator()
                + "garnishes" + System.lineSeparator();
        TestSupport.checkEquals(expected,
                Problem2.findDollarWords(input),
                "White space should be ignored and not affect the output");
        
        // Single valid word should be returned exactly as it appeared in the input.
        input = "garnishes";
        expected = "garnishes" + System.lineSeparator();
        TestSupport.checkEquals(expected,
                Problem2.findDollarWords(input),
                "One word input");

        // A whitespace-only input should produce no output.
        input = " ";
        expected = "";
        TestSupport.checkEquals(expected,
                Problem2.findDollarWords(input),
                "Whitespace-only input should produce no output");
         
        // An empty string should produce no output.
        input = "";
        expected = "";
        TestSupport.checkEquals(expected,
                Problem2.findDollarWords(input),
                "Empty input should produce no output");
         
        TestSupport.finish();
    }
}
