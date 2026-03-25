public class Program5 {
    
    static int Smallest(int arr[]){

        int smallestElement = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] < smallestElement)
                smallestElement = arr[i];
        }

        return smallestElement;
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{-1,-5,-8,-11};

        int ans = Smallest(arr);
        System.out.println("smallest element is " + ans);
    }
}
