class Program2 {
    
    static int Equilibrium(int arr[]){

        for(int i=0; i<arr.length; i++){
            
            int leftSum = 0;
            int rightSum = 0;

            for(int j=0; j<i; j++){
                leftSum += arr[j];
            }

            for(int k=i+1; k<arr.length; k++){
                rightSum += arr[k];
            }

            if(leftSum == rightSum){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // int arr[] = {-7,1,5,2,-4,3,0};
        int arr[] = {1,2,3};
        int ans = Equilibrium(arr);
        System.out.println(ans);
    }
}
