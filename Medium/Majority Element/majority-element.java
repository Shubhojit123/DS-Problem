//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        int el = 0;
        int c = 0;
        
        for(int i=0;i<size;i++)
        {
            if(c==0)
            {
                el = a[i];
                c=1;
            }
            else if(el == a[i])
            {
                c++;
            }
            else
            {
                c--;
            }
        }
            int c1 = 0;
            
            int m = size/2;
            
            for(int i=0;i<size;i++)
            {
                if(el == a[i])
                {
                    c1++;
                }
                
            }
            
            if(c1 > m)
                {
                    return el;
                }
               
            return -1;
    }
}