class Rec7{

    static int sum = 0;
    static int printSum(int num){
        if(num == 0)
            return 0;

        // sum = sum + num;
        // printSum(--num);

        // return sum;

        return num + printSum(--num);
    }

    public static void main(String[] args) {
        
        System.out.println(printSum(10));
    }
}
