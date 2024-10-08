//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
      public int help(int [] nums , int sum)
    {
             int n = nums.length;
            int[][]dp = new int[n+1][sum+1];
            
           for(int i = 0 ; i<=sum;i++)
           {
                   dp[0][i] = 0;
           }
            
           for(int j = 0 ; j<=n;j++)
           {
                   dp[j][0] = 1;
           }
            
            for(int i = 1 ; i<=n ; i++)
            {
                    for(int j=1;j<=sum;j++)
                    {
                            if(nums[i-1] <= j)
                            {
                                    dp[i][j] = Math.max(dp[i-1][j-nums[i-1]], dp[i-1][j]);
                            }
                            else
                            {
                                    dp[i][j] = dp[i-1][j];
                            }
                    }
            }
            
            return dp[n][sum];
    }
    static int equalPartition(int N, int arr[])
    {
        // code here
         Solution sc = new Solution();
         int n = arr.length;
            int sum = 0;
            for(int i= 0 ; i < n ; i++)
            {
                    sum += arr[i];
                    
            }
            
            
            if(sum % 2 != 0)
            {
                    return 0;
            }else
            {
                   return sc.help(arr,sum/2);
            }
    }
    
}