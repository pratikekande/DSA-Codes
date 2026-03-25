public class Program6 {
    
    static int SecondLargestElement(int arr[]){

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }

            if(arr[i] > secondLargest && largest != arr[i]){
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{-1,2,-5,-3,-100,-10};

        int ans = SecondLargestElement(arr);
        System.out.println(ans);
    }
}
