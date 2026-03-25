public class Program13 {
    
    static void CountVowelsConsonants(String s){

        int vowelCount = 0;
        int consonantCount = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
                vowelCount++;
            }else{
                consonantCount++;
            }
        }

        System.out.println(vowelCount);
        System.out.println(consonantCount);
    }

    public static void main(String[] args) {
        
        String s = "aeiouqwdfgj";
        CountVowelsConsonants(s);
    }
}
