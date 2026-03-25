public class Program7 {
    
    static void Reverse(int arr[]){

        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6};

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        Reverse(arr);
        System.out.println();

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
