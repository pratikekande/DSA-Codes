public class Program1 {
    
    static void CountEvenOdd(int arr[]){

        int even = 0, odd = 0;
        int n = arr.length;

        for(int i=0; i<n; i++){
            if(arr[i] % 2 == 0)
                even++;
            else
                odd++;
        }

        System.out.println("Even Count " + even);
        System.out.println("Odd Count " + odd);
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{1,2,3,4,5,6,7,8,9};

        CountEvenOdd(arr);
    }
}
 