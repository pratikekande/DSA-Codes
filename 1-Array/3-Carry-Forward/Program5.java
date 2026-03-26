class  CarryForward {
    
    static void LeftMaxArray(int arr[]){

        int leftMaxArr[] = new int[arr.length];
        leftMaxArr[0] = arr[0];


        for(int i=1; i<arr.length; i++){
            if(arr[i] > leftMaxArr[i-1]){
                leftMaxArr[i] = arr[i];
            }else{
                leftMaxArr[i] = leftMaxArr[i-1];
            }
        }

        for(int i=0; i<leftMaxArr.length; i++){
            System.out.print(leftMaxArr[i] + " ");
        }
        //System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = new int[]{-3,6,2,4,5,2,8,-9,3,1};

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        LeftMaxArray(arr);
    }
}
