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
    int l = 0;
    int r = 0;
    int len = 0;
    int n = s.length();
    int map[] = new int[256];
    Arrays.fill(map, -1);

    while (r < n) {
        char currentChar = s.charAt(r);
        if (map[currentChar] != -1 && map[currentChar] >= l) {
            l = map[currentChar] + 1;
            map[currentChar] = r;
        }
        len = r - l + 1;
        ans = Math.max(ans, len);
        map[currentChar] = r;
        r++;
    }

    return ans;
    }
}