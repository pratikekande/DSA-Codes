public class Program7 {
    
    static void PerfectNumber(int num){

        int sum = 0;
        for(int i=1; i<=num/2; i++){
            if(num % i == 0){
                sum += i;
            }
        }

        System.out.println(sum);

        if(sum == num){
            System.out.println("Perfect Number");
        } else{
            System.out.println("Not Perfect Number");
        }
    }

    public static void main(String[] args) {
        PerfectNumber(6);
    }
}
