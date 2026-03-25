public class Program4 {
    
    static void PrintSquareRoot(int num){

        int res = 1;
        while(res * res <= num){
            res++;
        }

        System.out.println(res - 1);
    }

    public static void main(String[] args) {
        PrintSquareRoot(11);
    }
}
