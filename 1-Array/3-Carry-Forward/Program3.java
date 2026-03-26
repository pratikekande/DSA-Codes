class RightMax {
    
    static void rightMax(int arr[]){

        int rightMaxArr[] = new int[arr.length];

        for(int i = arr.length - 1; i > 0; i--){
            int max = Integer.MIN_VALUE;

            for(int j= i; j < arr.length; j++){
                if(arr[j] > max){
                    max = arr[j];
                }
            }

            rightMaxArr[i] = max;
        }

        for(int k=0; k < rightMaxArr.length; k++){
            System.out.print(rightMaxArr[k] + " ");
        }
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{-3,6,2,4,5,2,8,-9,3,1};

        rightMax(arr);
    }
}
