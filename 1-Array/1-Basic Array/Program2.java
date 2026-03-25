import java.util.Arrays;

class Program2 {
    
    // static int count(int arr[], int k){

    //     int countElements = 0;
    //     for(int i=0; i<arr.length; i++){
    //         for(int j=0; j<arr.length; j++){
    //             if(i != j){
    //                 if(arr[i] + arr[j] == k){
    //                     countElements++;
    //                 }
    //             }
    //         }
    //     }

    //     return countElements;
    // }

    static int count(int arr[], int k){

        Arrays.sort(arr);   // Step 1: Sort
        int left = 0;
        int right = arr.length - 1;
        int countElements = 0;

        while(left < right){

            int sum = arr[left] + arr[right];

            if(sum == k){
                countElements++;
                left++;
                right--;
            }
            else if(sum < k){
                left++;
            }
            else{
                right--;
            }
        }

        return countElements;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3,5,2,1,-3,7,8,15,6,13};
        int k = 10;

        int ans = count(arr, k);
        System.out.println(ans);
    }
}
