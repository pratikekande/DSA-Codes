import java.util.Scanner;

class CarryForward {

    // Brute-Force approach
    // static int MaxElementUptoIndex(int arr[]){
    //     int max = Integer.MIN_VALUE;

    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter the index :");
    //     int j = sc.nextInt();
    //     for(int i=0; i<=j; i++){
    //         if(arr[i] > max)
    //             max = arr[i];
    //     }

    //     return max;
    // }

    

    // Optimized Approach for second variation of code, when queries are given

    static void MaxElementUptoIndex(int arr[]){

        int leftMax[] = new int[arr.length];
        leftMax[0] = arr[0];
        // int max = Integer.MIN_VALUE;

        for(int i=1; i<arr.length; i++){
            if(arr[i] > leftMax[i-1]){
                leftMax[i] = arr[i];
            }else{
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

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        MaxElementUptoIndex(arr);
        //System.out.println("The max element is " + ans);
    }
}
