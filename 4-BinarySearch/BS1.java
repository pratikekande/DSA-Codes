class BS{

    static int BinarySearch(int arr[], int targetEle){

        int startIndex = 0;
        int endIndex = arr.length-1;

        while(startIndex <= endIndex){

            int mid = (startIndex + endIndex)/2;

            if(arr[mid] == targetEle){
                return mid;
            }
            else if(arr[mid] > targetEle){
                endIndex = mid - 1;
            }
            else{
                startIndex = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{2,13,24,35,46,56,67,78};
        int targetEle = 56;

        int ans = BinarySearch(arr, targetEle);
        System.out.println(ans);
    }
}