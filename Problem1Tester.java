package assignment1;

/** Student-written tests for Problem 1. Add your own test cases below. */
public class Problem1Tester {
    public static void main(String[] args) {
        // Example of the required format only. Replace/add cases based on the specification.
        //Simple Inspection Tests
        TestSupport.checkEquals(5832L,
                Problem1.largestProduct("9989", 4),
                "1. example-sized prefix");
        TestSupport.checkEquals(12L,
                Problem1.largestProduct("1234", 2),
                "2. Correct Outputs");
        TestSupport.checkEquals(72L,
                Problem1.largestProduct("9876", 2),
                "3. Correct Outputs");
        //Incorrect Outputs Tests     
        //Zero Test and best answer uses fewer than n digits
        TestSupport.checkEquals(81L,
                Problem1.largestProduct("9099", 4),
                "4. Input with zeros should still output largest product of non-zero digits");
        TestSupport.checkEquals(1L,
                Problem1.largestProduct("10101010", 4),
                "5. Input with zeros should still output largest product of non-zero digits");
        
        // n > string length Test
        TestSupport.checkEquals(9L, 
                Problem1.largestProduct("90909", 6), 
                "6. Input with n larger than string length should still return largest product of non-zero digits");
        
        // Boundary Tests
        TestSupport.checkEquals(5L,
                Problem1.largestProduct("123451234", 1),
                "7. Input with n = 1 should return an error message");
        
        TestSupport.checkEquals(120L, 
                Problem1.largestProduct("123456321", 3), 
                "10. Input should return largest product of consecutive digits");
            
        TestSupport.checkEquals(6L, 
                Problem1.largestProduct("123456", 1), 
                "11. Input should return largest product of consecutive digits");

        TestSupport.finish();
    }
}
