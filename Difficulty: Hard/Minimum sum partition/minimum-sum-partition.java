//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static boolean subSetSum(int arr[] , int sum , boolean [][] dp)
    {
        int n  = arr.length;
        for(int i=0; i <=n ; i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(i == 0)
                {
                    dp[i][j] = false;
                }
                if(j == 0)
                {
                    dp[i][j] = true;
                }
            }
        }
        
        for(int i = 1 ; i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(arr[i-1] <= j)
                {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][sum];
    }
	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum = 0;
	    int ans = Integer.MAX_VALUE;
	    for(int i : arr){
	        sum += i;
	    }
	    
	    ArrayList<Integer> al = new ArrayList<>();
	    boolean [][] dp = new boolean[n+1][sum+1];
	    subSetSum(arr,sum,dp);
	    
	    for(int i = 0 ; i<=sum/2;i++)
	    {
	        if(dp[n][i])
	        {
	            al.add(i);
	        }
	    }
	    
	    for(int i = 0 ; i<al.size();i++)
	    {
	        ans = Math.min((sum-2*al.get(i)) , ans);
	    }
	   
	    return ans;
	} 
}
