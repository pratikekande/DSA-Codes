class Rec4{

    //static int count = 0;
    static int SumDigits(int n){
        if(n==0)
            return 0;

        // int rem = n % 10;
        // count++;
        // CountDigits(n/10);

        return n%10 + SumDigits(n/10);
    }

    public static void main(String[] args) {
        System.out.println(SumDigits(123));
    }
}
