class Rec6{

    static void printNum(int num){
        if(num == 0)
            return;

        // Basic Approach
        // System.out.println(num);
        // printNum(++num);

        // Better Approach
        // printNum(--num);
        // System.out.println(num+1);

        System.out.println(num);
        printNum(--num);
    }

    public static void main(String[] args) {
        printNum(10);
    }
}