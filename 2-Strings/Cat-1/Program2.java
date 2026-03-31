class StringDemo{

    // Print the first and last character of a string.
    public static void main(String[] args) {
        
        String s = "Core2Web";
        int n = s.length();

        System.out.println(s.charAt(0));
        System.out.println(s.charAt(n-1));

        System.out.println(s.toUpperCase());
    }
    
}
