public class Program5 {
    
    // Count how many characters (excluding spaces) are in the string.
    public static void main(String[] args) {
        
        String s = "Hello World";
        int count = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                continue;
            }else{
                count++;
            }
        }
        System.out.println(count);
    }
}
