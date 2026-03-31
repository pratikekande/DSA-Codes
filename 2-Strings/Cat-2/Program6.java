public class Program6 {
    
    // Count how many times a given character appears in a string.
    
    public static void main(String[] args) {
        
        String s = "Attitude";
        System.out.println(s);

        s.toLowerCase();
        char ch = 't';
        int count = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ch){
                count++;
            }
        }

        System.out.println(count);
    }
}
