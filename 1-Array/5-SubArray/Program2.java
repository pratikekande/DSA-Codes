class SubArray {
    
    // static int MinLenSubaaray(int arr[]){

    //     int minLength = Integer.MAX_VALUE;
    //     int maxValue = Integer.MIN_VALUE;
    //     int minValue = Integer.MAX_VALUE;
    //     int len = 0;

    //     for(int i=0; i<arr.length; i++){
    //         if(arr[i] < minValue)
    //             minValue = arr[i];
            
    //         if(arr[i] > maxValue)
    //             maxValue = arr[i];
    //     }

    //     for(int i=0; i<arr.length; i++){
    //         if(arr[i] == minValue){
    //             for(int j=i+1; j<arr.length; j++){
    //                 if(arr[j] == maxValue){
    //                     len = j-i+1;
    //                     if(minLength > len)
    //                         minLength = len;
    //                 }
    //             }
    //         } 
    //         else if(arr[i] == maxValue){
    //             for(int j=i+1; j<arr.length; j++){
    //                 if(arr[j] == minValue){
    //                     len = j-i+1;
    //                     if(minLength > len)
    //                         minLength = len;
    //                 }
    //             }
    //         }
    //     }

    //     return minLength;
    // }



    // OPTIMIZED APPROACH
    static int MinLenSubaaray(int arr[]){

        int minLength = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int len = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] < minValue)
                minValue = arr[i];
            
            if(arr[i] > maxValue)
                maxValue = arr[i];
        }

        int minPos = -1;
        int maxPos = -1;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == minValue)
                minPos = i;

            if(arr[i] == maxValue)
                maxPos = i;

            if(minPos != -1 && maxPos != -1){

                if(minPos > maxPos)
                    len = minPos - maxPos + 1;
                else
                    len = maxPos - minPos + 1;

                if(len < minLength)
                    minLength = len;
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,1,3,4,6,4,6,3};

        int ans = MinLenSubaaray(arr);
        System.out.println(ans);
    }
}
