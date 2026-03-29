class Program2 {
    
    public static void main(String[] args) {
        
        int arr[] = new int[]{-3,4,-2,5,3,-2,8,2,1,4};
        int k = 4;
        int n = arr.length;

        int start = 0;
        int end = k-1;

        while(end < n){
            for(int i = start; i<=end; i++){
                System.out.print(arr[i] + " ");
            }
            start++;
            end++;
            System.out.println();
        }
    }
}
