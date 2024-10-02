//{ Driver Code Starts
import java.io.*;
import java.util.*;

class gfg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int w = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] tokens = line.split(" ");
            List<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] val = new int[array.size()];
            int idx = 0;
            for (int i : array) val[idx++] = i;

            String lin = br.readLine();
            String[] toke = lin.split(" ");
            List<Integer> array1 = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : toke) {
                array1.add(Integer.parseInt(token));
            }

            int[] wt = new int[array1.size()];
            idx = 0;
            for (int i : array1) wt[idx++] = i;

            // calling method knapSack() of class Solution
            System.out.println(new Solution().knapSack(w, wt, val));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    public static int help(int w, int[] wt, int[] val, int n,int dp[][]) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if(dp[n][w] != -1)
        {
            return dp[n][w];
        }
        if (wt[n - 1] <= w) {
            return  dp[n][w] = Math.max(
                val[n - 1] + help(w - wt[n - 1], wt, val, n - 1,dp),
                help(w, wt, val, n - 1,dp)
            );
        } else {
            return  dp[n][w] = help(w, wt, val, n - 1,dp);
        }
    }

    static int knapSack(int w, int[] wt, int[] val) {
        int n = wt.length;
        int dp[][] = new int[n+1][w+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return help(w, wt, val, n,dp);
    }
}
