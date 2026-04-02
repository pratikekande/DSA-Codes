class Rec1{
    static void fun(){
        System.out.println("Hello");
        fun();
    }

    public static void main(String[] args) {
        fun();
    }
}