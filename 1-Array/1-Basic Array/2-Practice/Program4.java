public class Program4 {
    
    static int Largest(int arr[]){

        int largestElement = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > largestElement)
                largestElement = arr[i];
        }

        return largestElement;
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{-1,-5,-8,-11};

        int ans = Largest(arr);
        System.out.println("Largest element is " + ans);
    }
}
