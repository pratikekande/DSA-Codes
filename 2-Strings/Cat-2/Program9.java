public class Program9 {
    
    // Print how many words start with a vowel in a sentence.

    // Without using split
    static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }
    public static void main(String[] args) {
        String s = "apple is an orange umbrella";
        int count = 0;

        int n = s.length();

        for (int i = 0; i < n; i++) {

            // Check if current character is starting of a word
            if (i == 0 && isVowel(s.charAt(i))) {
                count++;
            }
            else if (s.charAt(i) == ' ' && i + 1 < n && isVowel(s.charAt(i + 1))) {
                count++;
            }
        }

        System.out.println(count);
    }



    // Using Split
    // public static void main(String[] args) {

    //     String s = "apple is an orange umbrella";

    //     String[] words = s.split(" ");
    //     int count = 0;

    //     for (int i = 0; i < words.length; i++) {

    //         String w = words[i];
    //         if (w.length() == 0) continue;

    //         char ch = w.charAt(0);

    //         if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
    //             ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
    //             count++;
    //         }
    //     }

    //     System.out.println(count);
    // }

}
