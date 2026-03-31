public class Program1 {

    // Count how many vowels and consonants are in a string. 
    
    public static void main(String[] args) {
        
        String s = "aeidd";
        int v = 0;
        int c = 0;

        for(int i=0; i<s.length(); i++){
            s.toLowerCase();
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' ){
                v++;
            } else{
                c++;
            }
        }

        System.out.println(v);
        System.out.println(c);
    }
}
