package assignment1;

public class IntensiveTest {
    static long reference(String s, int n) {
        if (s == null || s.isEmpty()) return 0;
        int maxLen = Math.min(n, s.length());
        long best = 0;

        for (int len = 1; len <= maxLen; len++) {
            for (int start = 0; start + len <= s.length(); start++) {
                long product = 1;
                for (int i = start; i < start + len; i++) {
                    product *= (s.charAt(i) - '0');
                }
                if (product > best) {
                    best = product;
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        String[] samples = {
            "0", "9", "10", "99", "9099", "10101010", "123456321",
            "55555555", "9989", "1234", "9876", "123451234", "1",
            "0000", "0009", "90909", "222222", "987654321", "4444444",
            "123456789", "9876543210", "999999999", "000000000",
            "1212121212", "1111111111", "987654321987654321"
        };

        for (String s : samples) {
            for (int n = 1; n <= s.length() + 2; n++) {
                long expected = reference(s, n);
                long actual = Problem1.largestProduct(s, n);
                if (actual != expected) {
                    System.out.println("FAIL sample: s=" + s + ", n=" + n + ", expected=" + expected + ", got=" + actual);
                    return;
                }
            }
        }

        for (int len = 1; len <= 5; len++) {
            for (int x = 0; x < (int)Math.pow(10, len); x++) {
                String s = String.format("%0" + len + "d", x);
                for (int n = 1; n <= len + 2; n++) {
                    long expected = reference(s, n);
                    long actual = Problem1.largestProduct(s, n);
                    if (actual != expected) {
                        System.out.println("FAIL exhaustive: s=" + s + ", n=" + n + ", expected=" + expected + ", got=" + actual);
                        return;
                    }
                }
            }
        }

        System.out.println("All intensive tests passed.");
    }
}
