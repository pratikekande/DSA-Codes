class insertion_sort {
    
    static void insertionsort(int arr[]){
        for(int i=0; i < arr.length; i++){
            
            int key = arr[i];

            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{9,7,8,4,1,3,6,2};

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        insertionsort(arr);

        System.out.println();

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
