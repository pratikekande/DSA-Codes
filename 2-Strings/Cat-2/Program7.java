public class Program7 {
    // Count how many alphabets are before ‘m’ and after ‘m’ in a given string. 

    public static void main(String[] args) {
        
        String s = "mmm";

        int beforeM = 0;
        int afterM = 0;

        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);
            if(ch >= 97 && ch < 109)
                beforeM++;
            else if(ch > 109 && ch <= 122)
                afterM++;
            else
                System.out.println("It is just m");
        }

        System.out.println(beforeM);
        System.out.println(afterM);
    }
}
