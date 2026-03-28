class SubArray {
    
    // KADANE'S ALGORITHM

    static void KadanesAlgorithm(int arr[]){

        int n = arr.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            sum = sum + arr[i];

            if(sum > maxSum)
                maxSum = sum;

            if(sum < 0)
                sum = 0;
        }

        System.out.println(maxSum);
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        KadanesAlgorithm(arr);
    }
}
