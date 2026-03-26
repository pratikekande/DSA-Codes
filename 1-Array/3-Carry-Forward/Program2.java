class LeftMax {
    
    static void leftMax(int arr[]){

        int leftMaxArr[] = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            int max = Integer.MIN_VALUE;

            for(int j=0; j<=i; j++){
                if(arr[j] > max){
                    max = arr[j];
                }
            }

            leftMaxArr[i] = max;
        }

        for(int k=0; k < leftMaxArr.length; k++){
            System.out.print(leftMaxArr[k] + " ");
        }
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{-3,6,2,4,5,2,8,-9,3,1};

        leftMax(arr);
    }
}
