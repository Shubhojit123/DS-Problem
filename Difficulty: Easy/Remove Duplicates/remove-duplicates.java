//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            String result = ob.removeDups(s);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String removeDups(String str) {
        // code here
        String ans = "";
        boolean[] map = new boolean[52];
        Arrays.fill(map, false);
// Assuming the string contains only lowercase letters a-z
        StringBuilder sb = new StringBuilder();
        remove(str, 0, sb, map);
        ans = sb.toString();
        return ans;
    }

    public static void remove(String str, int idx, StringBuilder sb, boolean[] map) {
        
        for(int i = 0 ; i<str.length();i++)
        {
            
        char curr = str.charAt(i);
        if (map[curr - 'a'] == false) {
            
     
            map[curr - 'a'] = true;
            sb.append(curr);
        
        }
    }
}
}