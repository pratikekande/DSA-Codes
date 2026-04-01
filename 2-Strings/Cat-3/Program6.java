public class Program6 {
    
    // Print the middle character(s) of a string. 

    public static void main(String[] args) {
        
        String s = "Helloo";

        int length = s.length();

        int middle = length/2;

        if(length % 2 == 0){
            System.out.println(" " + s.charAt(middle-1) + s.charAt(middle));
        } else{
            System.out.println(s.charAt(middle));
        }
    }
}
