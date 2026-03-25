public class Program12 {
    
     static void CheckPalindrome(String s){

        s = s.toLowerCase();
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
     }

     public static void main(String[] args) {
        
        String s = "Racecar";

        CheckPalindrome(s);
     }
}
