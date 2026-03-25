import java.util.ArrayList;

public class Program9 {
    
    static ArrayList<ArrayList<Integer>> FrequenyOfEachElement(int arr[]){
        int n = arr.length;

        boolean visited[] = new boolean[n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){

            if(visited[i])
                continue;
            int count = 1;

            // Store frequency of each element
            for(int j=i+1; j<n; j++){
                if(arr[i] == arr[j]){
                    visited[j] = true;
                    count++;
                }
            }

            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(arr[i]);
            temp.add(count);
            ans.add(temp);
        }

        return ans;
    }

    public static void main(String[] args) {
        
        int arr[] = {1, 2, 2, 3, 3, 3, 4};

        ArrayList<ArrayList<Integer>> result = FrequenyOfEachElement(arr);

        for (int i = 0; i < result.size(); i++) {
            ArrayList<Integer> pair = result.get(i);
            System.out.println(pair.get(0) + " -> " + pair.get(1));
        }
    }
}
