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
    
    static int matrixMultiplication(int arr[]) {
        // code here
        
        int n = arr.length;
        int dp[][] = new int[n][n];
        
       for(int len = 2 ; len <= n-1 ;len++)
       {
           for(int i = 1 ; i<=n-len;i++)
           {
              int j = i+len-1;
               
                dp[i][j] = Integer.MAX_VALUE;
               
               for(int k = i ; k<j;k++)
               {
                 dp[i][j] = Math.min(dp[i][j],dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j]);
               }
           }
       }
        
       return dp[1][n-1]; 
    }
}