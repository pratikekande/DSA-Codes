public class Program8 {
    
    // Compare two strings lexicographically (like dictionary order). 
    public static void main(String[] args) {
        
        String s1 = "car";
        String s2 = "cat";


        // How to interpret:
        // result < 0 → s1 comes before s2 in dictionary
        // result > 0 → s1 comes after s2
        // result == 0 → both are same
        System.out.println(s1.compareTo(s2));
    }
}
