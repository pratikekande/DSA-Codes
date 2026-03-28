class SubArray {
    
    // Print subArray which gives maximum sum

    static void MaxSubArraySumArray(int arr[]){

        int n = arr.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        int x = -1;
        int startIndex = -1;
        int endIndex = -1;

        for(int i=0; i<n; i++){
            
            if(sum == 0)
                x = i;

            sum = sum + arr[i];

            if(sum > maxSum){
                maxSum = sum;
                startIndex = x;
                endIndex = i;
            }

            if(sum < 0)
                sum = 0;
        }

        for(int i=startIndex; i<=endIndex; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArraySumArray(arr);
    }
}
