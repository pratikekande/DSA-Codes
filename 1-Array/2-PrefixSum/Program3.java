import java.util.Scanner;

class Program3 {
    
    static void inPlacePrefixSum(int arr[]){

        for(int i=1; i<arr.length; i++){
            arr[i] = arr[i-1] + arr[i];
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Scanner sc = new Scanner(System.in);

        // System.out.println("Enter number of quesries :");
        // int queries = sc.nextInt();

        // int sum = 0;

        // for(int i=0; i<queries; i++){

        //     System.out.println("Enter start and end index ");
        //     int startIndex = sc.nextInt();
        //     int endIndex = sc.nextInt();

        //     sum = sum + arr[endIndex] - arr[startIndex -1];
        //     System.out.println("Sum is " + sum); 
        // }
    }

    public static void main(String[] args) {
        // int arr[] = new int[]{-3,6,2,4,5,2,8,-9,3,1};
        int arr[] = new int[]{1,2,3,4,5};

        inPlacePrefixSum(arr);
    }
}
