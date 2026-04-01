public class Program5 {

    // Check if two strings are the reverse of each other.

    public static void main(String[] args) {

        String s1 = "abcd";
        String s2 = "dcba";

        if (s1.length() != s2.length()) {
            System.out.println("Not Reverse");
            return;
        }

        int i = 0;
        int j = s2.length() - 1;

        while (i < s1.length()) {

            if (s1.charAt(i) != s2.charAt(j)) {
                System.out.println("Not Reverse");
                return;
            }

            i++;
            j--;
        }

        System.out.println("Reverse of each other");
    }
}