public class Program8 {
    
    // Count how many substrings start and end with the same character (simple logic). 

    // [Expected Approach] Using Character Frequency - O(n) time and O(1) space

    public static void main(String[] args) {
      
        String s = "aba";
        int count = 0;
        int n = s.length();
        
        // Consider all possible substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {          
                // If first and last characters
                // of substring s[i..j] are same
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
