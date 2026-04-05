class QuickSort{

    static int partition(int arr[], int start, int end){

        int pivot = arr[end];
        int pivotIndex = start - 1;

        for(int i=start; i<end; i++){
            if(arr[i] < pivot){
                pivotIndex++;
                int temp = arr[i];
                arr[i] = arr[pivotIndex];
                arr[pivotIndex] = temp;
            }
        }

        pivotIndex++;
        int temp = arr[end];
        arr[end] = arr[pivotIndex];
        arr[pivotIndex] = temp;

        return pivotIndex;
    }

    static void quickSort(int arr[], int start, int end){

        if(start >= end)
            return;

        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex-1);
        quickSort(arr, pivotIndex+1, end);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{7,2,1,4,6,5,3};
        int start = 0;
        int end = arr.length-1;

        for(int i=start; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        quickSort(arr, start, end);

        for(int i=start; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}