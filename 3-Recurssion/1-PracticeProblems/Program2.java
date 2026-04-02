class Rec2{

    static int count = 3;
    static void fun(){
        if(count == 0){
            return;
        }

        System.out.println("hello");
        count--;
        fun();
    }

    public static void main(String[] args) {
        fun();
    }
}