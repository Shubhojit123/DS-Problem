//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
  public static int help(int a[], int mid) {
    int c = 0;
    for (int i = 0; i < a.length; i++) {
        c += (int) Math.ceil((double) a[i] / mid);
    }
    return c;
}

public static int smallestDivisor(int[] nums, int k) {
    int maxi = Integer.MIN_VALUE;
    
    for (int i = 0; i < nums.length; i++) {
        maxi = Math.max(nums[i], maxi);
    }
    
    int low = 1;  // Start from 1 because the smallest divisor should be at least 1
    int high = maxi;
    
    while (low <= high) {
        int mid = (low + high) / 2;
        int c = help(nums, mid);
        
        if (c <= k) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    
    return low;
}

}