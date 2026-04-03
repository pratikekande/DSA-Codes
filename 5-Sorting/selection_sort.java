class selection_sort {
    
    static void selectionsort(int arr[]){
        for(int i=0; i < arr.length-1; i++){
            int minIndex = i;

            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            //swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{9,7,8,4,1,3,6,2};

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        selectionsort(arr);

        System.out.println();

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
