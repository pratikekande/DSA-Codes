public class Program8 {
    
    static boolean CheckSorted(int arr[]){

        for(int i=1; i<arr.length; i++){
            if(arr[i] < arr[i-1]){
                System.out.println("Not Sorted");
                return false;
            }
        }

        System.out.println("Sorted");
        return true;
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{2,4,6,7,8};

        CheckSorted(arr);
    }
}
