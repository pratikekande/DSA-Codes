public class Program8 {
    // Remove the first and last character and print the remaining string. 

    public static void main(String[] args) {
        
        String s = "Attitude";

        // [Approach - 1] Using string.substring() Method - O(n) Time and O(1) Space
        // s = s.substring(1,s.length()-1);
        // System.out.println(s);

        // [Approach - 2] Using StringBuilder.deleteChatAt() Method - O(n) Time and O(n) Space
        StringBuilder sb = new StringBuilder(s);
        sb.deleteCharAt(s.length()-1);
        sb.deleteCharAt(0);
        String str;
        str = sb.toString();
        System.out.println(str);

    }
}
