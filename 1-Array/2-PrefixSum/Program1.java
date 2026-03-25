import java.util.Scanner;

class Program1 {
 
    // BRUTE FORCE
    static void printSum(int arr[]){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Queries :");
        int queries = sc.nextInt();
        for(int i=0; i<queries; i++){
            System.out.println("Enter start index :");
            int startIndex = sc.nextInt();
            System.out.println("Enter end index :");
            int endIndex = sc.nextInt();
            int sum = 0;
            for(int j=startIndex; j <= endIndex; j++){
                sum = sum + arr[j];
            }
            System.out.println("Sum is "+ sum);
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{-3,6,2,4,5,2,8,-9,3,1};

    }
}
