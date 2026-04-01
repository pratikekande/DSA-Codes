public class Program3 {
    
    // Reverse the order of words in a sentence.

    public static void main(String[] args) {
        
        String s = "Hello World";

        String words[] = s.split(" ");

        int left = 0;
        int right = words.length - 1;

        while (left <= right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;

            left++;
            right--;
        }

        for(int i=0; i<words.length; i++){
            System.out.print(words[i] + " ");
        }
    }
}
