public class Program5 {
    
    // Count how many spaces are there in a sentence. 

    public static void main(String[] args) {
        
        String s = "Hello World!, How are You?";

        int space = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                space++;
            }
        }

        System.out.println(space);
    }
}
