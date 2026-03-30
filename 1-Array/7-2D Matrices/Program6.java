public class Program6 {
    
    static void PrintLeftDiagonal(int arr[][]){

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i][i]);
        }
    }

    public static void main(String[] args) {
        int arr[][] = new int[][]{{1,2,3,4},{5,6,7,8}, {9,10,11,12}};

        PrintLeftDiagonal(arr);
    }
}
