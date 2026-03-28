class SubArray {
    
    static void SubArraySumCarryForward(int arr[]){

        for(int i=0; i<arr.length; i++){
            int sum = 0;
            for(int j=i; j<arr.length; j++){
                sum += arr[j];
                System.out.println(sum + " ");
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3};
        SubArraySumCarryForward(arr);
    }
}
