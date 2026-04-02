class Rec3{

    static int count = 0;
    static int CountDigits(int n){
        if(n==0)
            return 0;

        // int rem = n % 10;
        // count++;
        // CountDigits(n/10);

        return 1 + CountDigits(n/10);
    }

    public static void main(String[] args) {
        System.out.println(CountDigits(1234567));
    }
}
