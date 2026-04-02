class Rec8{

    //static int fact = 1;
    static int Fact(int num){

        if(num == 0)
            return 1;

        return num * Fact(--num);
    }

    public static void main(String[] args) {
        
        System.out.println(Fact(3));
    }
}
