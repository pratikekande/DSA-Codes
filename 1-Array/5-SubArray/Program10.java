class SubArray{
    
    // BRUTE FORCE APPROACH
    // static void MaxSubArraySum(int arr[]){
    //     int n = arr.length;
    //     int maxSum = Integer.MIN_VALUE;
    //     for(int i=0; i<n; i++){
    //         for(int j=i; j<n; j++){
    //             int sum = 0;
    //             for(int k=i; k<=j; k++){
    //                 sum = sum + arr[k];
    //             }
    //             if(sum > maxSum)
    //                 maxSum = sum;
    //         }
    //     }
    //     System.out.println(maxSum);
    // }


    // CARRY FORWARD APPROACH
    // static void MaxSubArraySum(int arr[]){

    //     int n = arr.length;
    //     int maxSum = Integer.MIN_VALUE;
    //     for(int i=0; i<n; i++){
    //         int sum = 0;
    //         for(int j=i; j<n; j++){
    //             sum = sum + arr[j];

    //             if(sum > maxSum)
    //                 maxSum = sum;
    //         }
    //     }
    //     System.out.println("The max sum is " + maxSum);
    // }


    // PREFIX-SUM APPROACH
    static void MaxSubArraySum(int arr[]){

        int n = arr.length;
        int prefixArr[] = new int[n];

        prefixArr[0] = arr[0];

        for(int i=1; i<n; i++){
            prefixArr[i] = arr[i] + prefixArr[i-1];
        }

        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                if(i==0)
                    sum = prefixArr[j];
                else
                    sum = prefixArr[j] - prefixArr[i-1];

                if(sum > maxSum)
                    maxSum = sum;
            }
        }
        System.out.println(maxSum);
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArraySum(arr);
    }
}
