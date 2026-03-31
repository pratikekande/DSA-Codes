public class Program3 {
    
    // Convert all characters of a string to uppercase.
    public static void main(String[] args) {

        // Why StringBuilder is faster?
        // String creates a new object each time you do result += ch
        // StringBuilder modifies characters in the same buffer, so it's faster and memory-efficient

        
        // USING STRING BUILDER
        String s = "hello world";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);  // Convert lowercase → uppercase
            }

            result.append(ch);
        }

        System.out.println(result.toString()); 


        // THIS IS NORMAL FORAMT
        // String s = "hello world";
        // String result = "";
        // for(int i=0; i<s.length(); i++){
        //     char ch = s.charAt(i);
        //     if(ch >= 'a' && ch <= 'z'){
        //         ch = (char)(ch - 32);
        //     }
        //     result += ch;
        // }
        // System.out.println(result);

    }
}
