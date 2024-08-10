//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    
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
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
         // your code here 
         
         return help(w,wt,val,n);
         
    } 
}


