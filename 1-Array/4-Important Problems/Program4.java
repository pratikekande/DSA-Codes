public class Program4 {
    
    // T.C -> O(n) & S.C -> O(1)
    static int Equilibrium(int arr[]) {

    int totalSum = 0;
    for(int i=0; i<arr.length; i++){
        totalSum += arr[i];
    }

    int leftSum = 0;
    int rightSum = 0;

    for(int i = 0; i < arr.length; i++) {

        rightSum = totalSum - arr[i] - leftSum; // right sum

        if(leftSum == rightSum)
            return i;

        leftSum += arr[i];
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
