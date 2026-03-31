public class Program4 {
    
    // Convert all characters of a string to lowercase.
    public static void main(String[] args) {
        
        String s = "HELLO WORLD";
        StringBuilder result = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch >= 'A' && ch <= 'Z'){
                ch = (char)(ch + 32);
            }

            result.append(ch);
        }

        System.out.println(result);
    }
}
