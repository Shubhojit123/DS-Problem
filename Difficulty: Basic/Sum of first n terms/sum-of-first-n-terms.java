//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.sumOfSeries(N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static long p(long n, long sum) {
    if (n < 0) {
        return sum;
    }
    
    return p(n - 1, sum + (long) Math.pow(n, 3));
}
    long sumOfSeries(long n) {
        // code here
        long sum = 0;
        
        return p(n,sum);
    }
}