public class Program10 {
    
    //  Count how many words end with ‘s’. 

    public static void main(String[] args) {
        String s = "this is cars bikes bus glass";
        String[] words = s.split(" ");

        int count = 0;

        for (int i = 0; i < words.length; i++) {

            String w = words[i];

            if (w.length() == 0) continue;

            // check last character
            if (w.charAt(w.length() - 1) == 's') {
                count++;
            }
        }

        System.out.println(count);



        // Without using split
        // String s = "this is cars bikes bus glass";
        //     int count = 0;

        //     int n = s.length();

        //     for (int i = 0; i < n; i++) {

        //         // Find end of a word:
        //         // A word ends when:
        //         // - current char is not space
        //         // - next char is space OR next index is end of string
        //         if (s.charAt(i) != ' ' && (i == n - 1 || s.charAt(i + 1) == ' ')) {

        //             // Check if this last char is 's'
        //             if (s.charAt(i) == 's') {
        //                 count++;
        //             }
        //         }
        //     }

        //     System.out.println(count);

    }
}
