public class Program9 {
    
    // Print the ASCII value of each character in a string. 
    public static void main(String[] args) {
        
        String s = "ABCxyz";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int ascii = (int) ch;  
            System.out.println(ch + " = " + ascii);
        }
    }
}
