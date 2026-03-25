public class Program8 {
    
    static void Fibonica(int num){
        int num1 = 0;
        int num2 = 1;
        int i = 0;

        while(i < num){
            System.out.print(num1 + " ");
            int num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
            i++;
        }
    }

    public static void main(String[] args) {
        Fibonica(9);
    }
}
