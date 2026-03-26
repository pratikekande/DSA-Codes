class  CarryForward {
    
    static void RightMaxArray(int arr[]){

        int rightMaxArr[] = new int[arr.length];
        rightMaxArr[arr.length - 1] = arr[arr.length - 1];


        for(int i=arr.length - 2; i>=0; i--){
            if(arr[i] > rightMaxArr[i+1]){
                rightMaxArr[i] = arr[i];
            }else{
                rightMaxArr[i] = rightMaxArr[i+1];
            }
        }

        for(int i=0; i<rightMaxArr.length; i++){
            System.out.print(rightMaxArr[i] + " ");
        }
        //System.out.println();
    }


    // BRUTE FORCE
    // static void RightMaxArray(int arr[]){

    //     int rightMaxArr[] = new int[arr.length];

    //     for(int i = arr.length - 1; i >= 0; i--){
    //         int max = Integer.MIN_VALUE;

    //         for(int j=i; j<arr.length; j++){
    //             if(arr[j] > max){
    //                 max = arr[j];
    //             }
    //         }

    //         rightMaxArr[i] = max;
    //     }

    //     for(int k=0; k < rightMaxArr.length; k++){
    //         System.out.print(rightMaxArr[k] + " ");
    //     }
    // }

    public static void main(String[] args) {
        int arr[] = new int[]{-3,6,2,4,5,2,8,-9,3,1};

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        RightMaxArray(arr);
    }
}
