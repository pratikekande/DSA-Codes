
class SubArray {
    
    // BRUTE FORCE APPROACH
    static void SumOfEverySubArray(int arr[]){

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("The SubArrays are :");

        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                int sum = 0;
                for(int k=i; k<=j; k++){
                    sum = sum + arr[k];
                }
                System.out.println(sum);
            }
        }
    }


    public static void main(String[] args) {
        
        int arr[] = new int[]{1,2,3};
        SumOfEverySubArray(arr);
    }
}
