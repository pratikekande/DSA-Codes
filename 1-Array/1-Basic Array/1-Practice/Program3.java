public class Program3 {
    
    static void PrintDigits(int num){

        while(num > 0){
            int digit = num % 10;
            System.out.println(digit);
            num = num / 10;
        }
    }

    public static void main(String[] args) {
        PrintDigits(123);
    }
}
