//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.Solve(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
     public static int maxEle(int []arr)
    {
            int maxi= Integer.MIN_VALUE;
            for(int i = 0 ; i < arr.length; i++)
            {
                   maxi= Math.max(maxi,arr[i]);
            }
            return maxi;
    }
    public static int help(int []a , int hour)
    {
        int totalHour = 0;
        
        for(int i = 0 ; i < a.length; i++)
        {
            totalHour += Math.ceil(((double)(a[i]) / (double)(hour)));
        }
        return totalHour;
    }
    public static int Solve(int[] piles, int h) {
        // code here
        
        int low = 1;
        int high = maxEle(piles);
        
        while(low <= high)
        {
            int mid = (low+high)/2;
            int hour = help(piles,mid);
            if(hour <= h)
            {
                high = mid - 1;
            }
            else
            {
                low = mid+1;
            }
        }
        
        return low;
    }
}
