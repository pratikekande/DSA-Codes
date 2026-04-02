class Rec3{
    static void printNum(int num){
        if(num == 0)
            return;

        System.out.println(num);
        //printNum(--num);
        
        // Stack overflow error
        printNum(num--);
    }

    public static void main(String[] args) {
        printNum(5);
    }
}