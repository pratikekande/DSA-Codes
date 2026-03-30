class Program3 {
    
    static void PrintRowWiseSum(int arr[][]){

        for(int i=0; i<arr.length; i++){
            int sum = 0;
            for(int j=0; j<arr[i].length; j++){
                sum = sum + arr[i][j];
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        int arr[][] = new int[][]{  {1,2,3},
                                    {1,2,3}, 
                                    {1,2,3}
                                };

        PrintRowWiseSum(arr);
    }
}
