class Program1 {
    

    // Brute-force Approach
    // static int Count(int arr[]){

    //     int countElements = 0;
    //     for(int i=0; i<arr.length; i++){
    //         for(int j=0; j<arr.length; j++){
    //             if(arr[j]>arr[i]){
    //                 countElements++;
    //                 break;
    //             }
    //         }
    //     }
    //     return countElements;
    // }


    // OPTIMIZED APPROACH
    static int Count(int arr[]){

        int countElements = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] < max){
                countElements++;
            }
        }

        return countElements;
    }


    public static void main(String[] args) {
        int arr[] = new int[]{2,5,1,4,8,0,1,3,8};

        int ans = Count(arr);
        System.out.println(ans);
    }
}
