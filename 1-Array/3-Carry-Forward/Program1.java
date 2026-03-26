import java.util.Scanner;

class CarryForward{

    // Brute-Force approach

    // static int MaxElement(int arr[], int i){

    //     int max = Integer.MIN_VALUE;
        
    //     for(int j = 0; j <= i; j++){
    //         if(arr[j] > max){
    //             max = arr[j];
    //         }
    //     }

    //     return max;
    // }



    // Optimized Approach for second variation of code, when queries are given

    static void MaxElement(int arr[]){

        int leftMax[] = new int[arr.length];

        leftMax[0] = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > leftMax[i-1]){
                leftMax[i] = arr[i];
            } else{
                leftMax[i] = leftMax[i-1];
            }
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of queries :");
        int q = sc.nextInt();

        for(int i = 0; i < q; i++){
            
            System.out.println("Enter index :");
            int j = sc.nextInt();

            System.out.println(leftMax[j]);
        }
    }



    public static void main(String[] args) {
        
        int arr[] = new int[]{3, 4, 5, 1, 2, 7, 9, 8};
        // int i = 3;

        MaxElement(arr);
    }
}
