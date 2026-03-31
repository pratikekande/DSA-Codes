public class Program3 {
    
    // Count how many uppercase and lowercase letters a string has.

    public static void main(String[] args) {
        
        String s = "HeLLo";

        int upper = 0;
        int lower = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if((int)ch >= 65 && (int)ch <= 90){
                upper++;
            }else if (ch >= 97 && ch <= 122) {
                lower++;
            }
        }
        System.out.println(upper);
        System.out.println(lower);
    }
}
