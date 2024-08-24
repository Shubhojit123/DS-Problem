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
      public static int help(int w, int wt[], int val[], int n)
    {
        int dp[][] = new int[n+1][w+1];
         for(int i = 0 ; i<dp.length;i++)
         {
             dp[i][0] = 0;
         }
         
         for(int i = 0; i < dp[0].length;i++)
         {
             dp[0][i] = 0;
         }
         
         for(int i = 1 ; i < n+1;i++)
         {
             for(int j = 1 ; j <w+1;j++)
             {
                 int wei = wt[i-1];
                 int v = val[i-1];
                 
                 if(wei <= j)
                 {
                     int inc = v + dp[i-1][j-wei];
                     int esc = dp[i-1][j];
                     dp[i][j] = Math.max(inc,esc);
                 }
                 else
                 {
                     dp[i][j] = dp[i-1][j];
                 }
             }
         }
         
         return dp[n][w];
         
    }
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
        int n = wt.length;
        return help(W,wt,val,n);
        
    }
}
