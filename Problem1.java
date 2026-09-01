 /* Student Name: Anka Oberhelman, Lab Section: 18685 */


package assignment1;

/*
 * Starter implementation for Assignment #1, Problem 1.
 *
 * IMPORTANT: This implementation is intentionally imperfect.
 * Your job is NOT to replace it immediately. First, develop a strong
 * test suite that exposes its defects and documents the intended
 * behavior described in the assignment.
 */
public class Problem1 {

    public static long largestProduct(String s, int n) {
        long largest = 0;

        if (n > s.length()) {
            n = s.length();
        }
        if (n > 20 || n < 2) {
            System.out.println("n must be between 2 and 20 inclusive.");
            return -1;
        }
        for (int i = 0; i < s.length(); i++) {
            long product = 1;
            for(int k = 0; k < n; k++) {
                if(i+(n-k) > s.length()) {
                    continue;
                }  
                for (int j = 0; j < n-k; j++) {
                    product *= (s.charAt(i + j) - '0');
                }
                if (product > largest) {
                    largest = product;
                    product = 1;
                }
                product = 1;
            }
        }

        return largest;
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        System.out.println(largestProduct(s, n));
    }
}
