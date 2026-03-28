class Program {
    

    public static void main(String[] args) {
        
        int arr[] = new int[]{3,-1,4};

        int totalSum = 0;

        for(int i=0; i<arr.length; i++){
            int sum = 0;
            for(int j=i; j<arr.length; j++){
                sum += arr[j];
                totalSum = totalSum + sum;
            }
        }

        System.out.println(totalSum);
    }
}
