public class Program4 {
    
    // Check whether a string is a palindrome

    public static void main(String[] args) {
        
        String s = "Racecar";
        s = s.toLowerCase();

        // TWO POINTER APPROACH
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                System.out.println("Not Palindrome");
                return;
            } 
            left++;
            right--;
        }

        System.out.println("Palindrome");

        // Using built-in function
        // String s1;
        // StringBuffer res = new StringBuffer(s);
        // res.reverse();
        // s1 = res.toString();
        // if(s1.equals(s))
        //     System.out.println("Palindrome");
        // else
        //     System.out.println("Not Palindrome");

    }
}
