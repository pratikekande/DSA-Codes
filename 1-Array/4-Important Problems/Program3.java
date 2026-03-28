public class Program3 {
    
    // T.C : O(3n) and S.C = O(2n)
    static int Equilibrium(int arr[]){

        int n = arr.length;

        int prefixSum[] = new int[n];
        int suffixSum[] = new int[n];

        prefixSum[0] = arr[0];
        suffixSum[n-1] = arr[n-1];

        for(int i=1; i<n; i++){
            prefixSum[i] = arr[i] + prefixSum[i-1];
        }

        for(int i=n-2; i>=0; i--){
            suffixSum[i] = arr[i] + suffixSum[i+1];
        }

        for(int i=0; i<n; i++){
            if(prefixSum[i] == suffixSum[i])
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {-7,1,5,2,-4,3,0};
        // int arr[] = {1,2,3};
        int ans = Equilibrium(arr);
        System.out.println(ans);
    }
}
