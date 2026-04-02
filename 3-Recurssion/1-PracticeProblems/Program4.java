class Rec4{

    static int printNum(int num){
        if(num == 0)
            return 1;

        return 5 + printNum(--num);
    }

    public static void main(String[] args) {
        int ans = printNum(3);
        System.out.println(ans);
    }
}