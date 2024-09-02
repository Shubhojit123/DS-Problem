//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine();
            String[] S = s.split(" ");
            long x = Long.parseLong(S[0]);
            long n = Long.parseLong(S[1]);
            long m = Long.parseLong(S[2]);
            Solution ob = new Solution();
            long ans = ob.PowMod(x, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long PowMod(long a, long n, long m)
    {
        // Code here
        long ans = 1;  // Initialize result
    a = a % m;     // Update a if it is more than or equal to m
    
    if (a == 0) return 0; // In case a is divisible by m

    while (n > 0) {
        // If n is odd, multiply a with result
        if ((n & 1) != 0) {
            ans = (ans * a) % m;
        }

        n = n >> 1;  // Divide n by 2
        a = (a * a) % m;  // Change a to a^2
    }
    
    return ans % m;
}
    
}