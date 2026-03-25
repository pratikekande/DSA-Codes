public class Program5 {
    
    static void SumOfEvenDigits(int num){

        int sum = 0;
        while(num > 0){
            int digit = num % 10;
            if(digit % 2 == 0){
                sum += digit;
            }
            num = num/10;
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        
        SumOfEvenDigits(2464);
    }
}
