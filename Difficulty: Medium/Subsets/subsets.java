//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            ArrayList<Integer> A = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                A.add(arr[i]);
            }

            ArrayList<ArrayList<Integer>> res = new Solution().subsets(A);
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
            // System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
      static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    
    public static void help(ArrayList<Integer> a, ArrayList<Integer> temp, int i) {
        if (i == a.size()) {
            ans.add(new ArrayList<>(temp));
            return;    
        }
        
          temp.add(a.get(i));
        help(a, temp, i + 1);
        
        
        temp.remove(temp.size() - 1);
        help(a, temp, i + 1);
    }
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        // code here
         ans.clear();  // Clear previous results
        help(a, new ArrayList<>(), 0);
        Collections.sort(ans, (o1, o2) -> {
            int len = Math.min(o1.size(), o2.size());
            for (int i = 0; i < len; i++) {
                if (!o1.get(i).equals(o2.get(i))) {
                    return o1.get(i) - o2.get(i);
                }
            }
            return o1.size() - o2.size();
        });
        
        return ans;
        
    }
}