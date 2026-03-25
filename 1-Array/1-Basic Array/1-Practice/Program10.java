public class Program10 {
    
    static boolean CheckPalindrome(int num){

        int rev = 0;
        int temp = num;
        while(num > 0){
            rev = rev * 10 + (num%10);
            num = num/10;
        }

        if(rev == temp){
            System.out.println("Palindrome");
            return true;
        }

        System.out.println("Not Palindrome");
        return false;
    }

    public static void main(String[] args) {
        CheckPalindrome(11);
    }
}
