import java.util.Scanner;

class SubArray {
    
    static void PrintSubArray(int arr[]){

        Scanner sc = new Scanner(System.in);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("Enter start index :");
        int startIndex = sc.nextInt();

        System.out.println("Enter end index :");
        int endIndex = sc.nextInt();

        sc.close();

        System.out.println("The SubArray is :");

        for(int i=startIndex; i<=endIndex; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{4,2,10,3,12,-2,15};
        PrintSubArray(arr);
    }
}
