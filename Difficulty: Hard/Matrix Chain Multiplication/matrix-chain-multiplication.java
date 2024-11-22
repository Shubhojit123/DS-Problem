//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int help(int arr[], int i, int j,int dp[][]) {
        if (i >= j) {
            return 0;
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }

        int minCost = Integer.MAX_VALUE;

        for (int k = i; k <= j-1; k++) {
            int tempCost = help(arr, i, k,dp) + help(arr, k + 1, j,dp) + arr[i - 1] * arr[k] * arr[j];
            minCost = Math.min(minCost, tempCost);
        }

        return dp[i][j] = minCost;
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        
        int n = arr.length;
        int dp[][] = new int[n+1][n+1];
        
        for(int i = 0 ; i<n;i++)
        {
            for(int j = 0 ; j<n;j++)
            {
                dp[i][j] = -1;
            }
        }
        
        return help(arr,1,n-1,dp);
        
        
    }
}