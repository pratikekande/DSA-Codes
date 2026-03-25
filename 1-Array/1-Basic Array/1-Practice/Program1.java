class Program1 {
    
    static void CompositeNumbers(int num){

        int count = 0;
        for(int i=1; i*i<=num; i++){
            if(num % i == 0){
                count = count + 2;
            }
            if(count > 2){
                System.out.println("The Number is composite");
                return; 
            }
        }
        System.out.println("The number is prime");
    }

    public static void main(String[] args) {
        CompositeNumbers(15);
    }
}
