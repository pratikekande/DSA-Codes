class BS_Rec1 {
    
    static int BinarySearch(int arr[], int startIndex, int endIndex, int targetEle){

        if(startIndex > endIndex){
            return -1;
        }

        int mid = (startIndex+endIndex)/2;

        if(arr[mid] == targetEle){
            return mid;
        }
        else if(arr[mid] > targetEle){
            return BinarySearch(arr, startIndex, mid - 1, targetEle);
        }
        else{
            return BinarySearch(arr, mid+1, endIndex, targetEle);
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2,13,24,35,46,56,67,78};
        int targetEle = 56;

        int ans = BinarySearch(arr, 0, arr.length-1, targetEle);
        System.out.println(ans);
    }
}
