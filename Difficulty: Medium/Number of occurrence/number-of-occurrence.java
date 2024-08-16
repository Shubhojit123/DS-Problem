//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
     public static int lastOccurence(int nums[],int n , int x)
    {
        int low = 0;
        int high = n-1;
        int fo=-1;
        while(low<= high)
        {
            int mid = (low+high)/2;
            if(nums[mid] == x)
            {
                fo = mid;
                low = mid+1;
            }
            else if(nums[mid] > x)
            {
                high = mid-1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        return fo;
    }
    public static int firstOccurence(int nums[],int n , int x)
    {
        int low = 0;
        int high = n-1;
        int fo=-1;
        while(low<= high)
        {
            int mid = (low+high)/2;
            if(nums[mid] == x)
            {
                fo = mid;
                high = mid-1;
            }
            else if(nums[mid] > x)
            {
                high = mid-1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        return fo;
    }
    int count(int[] nums, int n, int x) {
        // code here
        int fo = firstOccurence(nums,n,x);
        int lo = lastOccurence(nums,n,x);
        
        if(fo == -1)
        {
            return 0;
        }
        
        return lo-fo+1;
    }
}