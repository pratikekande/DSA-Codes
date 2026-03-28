import java.util.Scanner;

class SubArray {
    
    static void PrintSubArraySum(int arr[]){

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

        int sum = 0;
        for(int i=startIndex; i<=endIndex; i++){
            sum = sum + arr[i];
        }

        System.out.println("The sum is :" + sum);
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{4,2,10,3,12,-2,15};
        PrintSubArraySum(arr);
    }
}
