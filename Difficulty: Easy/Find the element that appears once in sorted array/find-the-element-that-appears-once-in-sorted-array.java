//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int arr[], int n)
    {
        // Complete this function
 
        int ans = 0;
        if(n == 1 || n ==2)
        {
            return arr[0];
        }
       
        for(int i = 1;i<n;i++)
        {
            if(i == 1)
            {
                if(arr[i-1] != arr[i])
                {
                    ans = arr[i-1];
                    break;
                }
            }
            else if(i == n-2)
            {
                if(arr[i] != arr[i+1])
                {
                    ans = arr[i+1];
                    break;
                }
            }
            else if(arr[i-1] != arr[i] && arr[i] != arr[i+1])
            {
                ans = arr[i];
                break;
            }
           
        }
        return ans;
    }
}