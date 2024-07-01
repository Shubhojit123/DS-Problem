//{ Driver Code Starts
import java.util.*;
import java.util.stream.*; 
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String s,String t)
    {
        
        // Your code here
        
        if (s.length() != t.length()) {
            return false;
        }

        TreeMap<Character, Integer> mps = new TreeMap<>();
        TreeMap<Character, Integer> mpt = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            mps.put(s.charAt(i) , mps.getOrDefault(s.charAt(i) , 0)+1);
            mpt.put(t.charAt(i) , mpt.getOrDefault(t.charAt(i) , 0)+1);
        }

        Set<Character> setS = mps.keySet();
        Set<Character> setT = mpt.keySet();

        for (Character key : setS) {
            if (!mps.get(key).equals(mpt.get(key))) {
                return false;
            }
        }

        return true;
        
    }
}