class bubble_sort {

    // //NORMAL CASE
    // static void bubbleSort(int arr[]){

    //     int outerCount = 0;
        
    //     for(int i = 0; i < arr.length-1; i++){

    //         int innerCount = 0;
    //         for(int j = 0; j < arr.length-i-1; j++){

    //             if(arr[j] > arr[j+1]){

    //                 int temp = arr[j];
    //                 arr[j] = arr[j+1];
    //                 arr[j+1] = temp;
    //             }

    //             innerCount++;
    //         }

    //         System.out.println("Inner count is :" + innerCount);

    //         outerCount++;
    //     }

    //     System.out.println("Outer count is :" + outerCount);
    // }


    //WHEN THE ENTIRE ARRAY IS SORTED, The T.C is O(n)
    //FOR THIS WILL CHECK SWAP CONDITION
    static void bubbleSort(int arr[]){

        int outerCount = 0;
        
        for(int i = 0; i < arr.length-1; i++){

            boolean swapped = false;
            int innerCount = 0;
            for(int j = 0; j < arr.length-i-1; j++){

                if(arr[j] > arr[j+1]){

                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    swapped = true;
                }

                innerCount++;
            }

            System.out.println("Inner count is :" + innerCount);

            if(swapped == false){
                break;
            }

            outerCount++;
            
        }

        System.out.println("Outer count is :" + outerCount);
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{1,2,3,4,5,6};

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        bubbleSort(arr);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
