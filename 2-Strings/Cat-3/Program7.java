public class Program7 {
    
    // Print the second half of the string in reverse.

    public static void main(String[] args) {
        
        String s = "Attitude";

        int length = s.length();
        int middle = length/2;

        for(int i= s.length()-1; i>=middle; i--){
            System.out.print(s.charAt(i));
        }
    }
}
