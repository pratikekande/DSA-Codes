public class Program1 {
    
    // Reverse a string without using built-in reverse.

    public static void main(String[] args) {
        
        String s = "Pratik";

        // Using built-in functions
        // StringBuilder res = new StringBuilder(s);
        // res.reverse();
        // s = res.toString();
        // System.out.println(s);

        // Using Backward Traversal – O(n) Time and O(n) Space
        // StringBuilder res = new StringBuilder();
        // for(int i=s.length()-1; i>=0; i--){
        //     res.append(s.charAt(i));
        // }
        // s = res.toString();
        // System.out.println(s);

        // Using Two Pointers - O(n) Time and O(1) Space
        int left = 0, right = s.length() - 1;
        StringBuilder res = new StringBuilder(s);
        while (left < right) {
            char temp = res.charAt(left);
            res.setCharAt(left, res.charAt(right));
            res.setCharAt(right, temp);
            left++;
            right--;
        }
        s = res.toString();
        System.out.println(s);

    }
}
