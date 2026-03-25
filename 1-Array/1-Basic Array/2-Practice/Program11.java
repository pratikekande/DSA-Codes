public class Program11 {
    
    public static void main(String[] args) {
        
        String s = "Race";

        // Printing the reverse
        // for(int i=s.length() - 1; i >= 0; i--){
        //     System.out.print(s.charAt(i));
        // }

        char arr[] = new char[s.length()];

        for(int i=s.length()-1; i>=0; i--){
            arr[s.length() - 1 - i] = s.charAt(i);
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
