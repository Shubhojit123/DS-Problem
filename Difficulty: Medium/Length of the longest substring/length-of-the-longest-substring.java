//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String s){
       int ans = 0;
    int[] mark = new int[256]; // Array to store characters' last seen positions
    Arrays.fill(mark, -1); // Initialize all positions to -1
    int start = 0; // Start of the current substring without duplicates

    for (int i = 0; i < s.length(); i++) {
        char currentChar = s.charAt(i);

        // If the character was seen in the current valid window, update the start
        if (mark[currentChar] >= start) {
            start = mark[currentChar] + 1;
        }

        // Update the character's last seen position
        mark[currentChar] = i;

        // Calculate the current length of the substring
        ans = Math.max(ans, i - start + 1);
    }

    return ans;
    }
}