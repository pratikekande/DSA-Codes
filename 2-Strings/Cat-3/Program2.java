public class Program2 {
    
    // Reverse each word in a sentence.

    public static void main(String[] args) {
        
        String s = "Hi, Hello World";

        String word = "";

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch != ' '){
                word = ch + word;
            }else {
                System.out.print(word + " ");
                word = "";
            }
        }
        System.out.print(word);

    }
}
