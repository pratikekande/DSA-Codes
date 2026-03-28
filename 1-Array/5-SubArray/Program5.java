
class SubArray {
    
    // BRUTE FORCE APPROACH
    static void PrintAllSubArray(int arr[]){

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("The SubArrays are :");

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                for(int k=i; k<=j; k++){
                    if(k != j)
                        System.out.print(arr[k] + " ");
                    else
                        System.out.println(arr[k] + " ");
                }
            }
        }
    }


    public static void main(String[] args) {
        
        int arr[] = new int[]{1,2,3};
        PrintAllSubArray(arr);
    }
}
