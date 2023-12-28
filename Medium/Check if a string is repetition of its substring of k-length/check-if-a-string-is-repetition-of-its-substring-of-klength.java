//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String s = sc.next();
            int k = sc.nextInt();
            int answer = new Solution().kSubstrConcat(n,s,k);
    		System.out.println(answer);
        }
        
    }
}

// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    int kSubstrConcat(int n, String s, int k)
    {
        // Your Code Here   
        if(n%k != 0) return 0;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i+k<=n; i+=k){
            String chunk = s.substring(i, i+k);
            map.put(chunk, map.getOrDefault(chunk, 0)+1);
        }
        int count = 0;
        for(String key : map.keySet()) {
            if(map.get(key) > 1) count++;
        }
        if(map.size() > 2) return 0;
        return count >= 2 ?0: 1;

}
}