import java.util.Scanner;

class Program2 {
    
    static void prefixSum(int arr[]){

        int prefixArr[] = new int[arr.length];
        prefixArr[0] = arr[0];

        for(int i=1; i<arr.length; i++){
            prefixArr[i] = prefixArr[i-1] + arr[i];
        }

        for(int i=0; i<prefixArr.length; i++){
            System.out.print(prefixArr[i] + " ");
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of queries");
        int queries = sc.nextInt();

        int sum = 0;

        for(int i=0; i<queries; i++){

            System.out.println("Enter start and end index");
            int startIndex = sc.nextInt();
            int endIndex = sc.nextInt();

            if(startIndex == 0){
                sum = prefixArr[endIndex];
            } else{
                sum = prefixArr[endIndex] - prefixArr[startIndex - 1];
            }

            System.out.println("Sum is " + sum);
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{-3,6,2,4,5,2,8,-9,3,1};

        prefixSum(arr);
    }
}
