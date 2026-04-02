class Rec5{

    static int printNum(int num){
        if(num == 0)
            return 1;

        printNum(--num);
        return 5 + num;
    }

    public static void main(String[] args) {
        int ans = printNum(3);
        System.out.println(ans);
    }
}