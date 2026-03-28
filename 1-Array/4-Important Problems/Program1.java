class Program1 {
    
    // static int countPair(char arr[]){
    //     int count = 0;

    //     for(int i=0; i<arr.length; i++){
    //         if(arr[i] == 'a'){
    //             for(int j= i+1; j<arr.length; j++){
    //                 if(arr[j] == 'g'){
    //                     count++;
    //                 }
    //             }
    //         }
    //     }

    //     return count;
    // }



    // OPTIMIZED APPROACH
    static int countPair(char arr[]){
        int Acount = 0;
        int pairCount = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == 'a'){
                Acount++;
            } else if(arr[i] == 'g'){
                pairCount = pairCount + Acount;
            }
        }

        return pairCount;
    }

    public static void main(String[] args) {
        char arr[] = new char[]{'a','b','e','g','a','g'};

        int ans = countPair(arr);
        System.out.println(ans);
    }
}
