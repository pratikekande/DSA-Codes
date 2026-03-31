public class Program2 {
    
    // Count the number of digits, letters, and special characters in a string.

    public static void main(String[] args) {
        
        String s = "Hell@123";
        int character = 0;
        int digits = 0;
        int special = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z'){
                character++;
            } else if(ch >= '0' && ch <= '9'){
                digits++;
            } else{
                special++;
            }
        }

        System.out.println(character);
        System.out.println(digits);
        System.out.println(special);
    }
}
