class SubArray{

    // static void PrintSumOfAllSubArrayFromIndex(int arr[]){

    //     int n = arr.length;

    //     for(int i=2; i<n; i++){

    //         int sum = 0;
    //         for(int j=2; j<=i; j++){
    //             sum = sum + arr[j];
    //         }
    //         System.out.println(sum);
    //     }
    // }


    static void PrintSumOfAllSubArrayFromIndex(int arr[]){

        int n = arr.length;

        int j = 2;
        int sum = 0;
        for(int i=2; i<=j; i++){
            sum = sum + arr[i];
            if(j < n-1)
                j++;

            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{7,3,2,-1,6,8,2,5};
        PrintSumOfAllSubArrayFromIndex(arr);
    }
}