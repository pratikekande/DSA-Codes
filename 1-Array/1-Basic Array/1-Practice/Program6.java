public class Program6 {
    
    static void PrintEvenDigitsSquareOddDigits(int num){

        int square = 1;
        while(num > 0){
            int digit = num % 10;
            if(digit % 2 == 0){
                System.out.println(digit);
            }
            else{
                square = digit * digit;
                System.out.println(square);
            }
            num = num/10;
        }
    }

    public static void main(String[] args) {
        
        PrintEvenDigitsSquareOddDigits(333);
    } 
}
