//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.countSubstring(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public static int countSubstring(String s) {
        // code here
        int n = s.length();
        int c = 0;
        int [] last = new int[3];
        Arrays.fill(last,-1);
        for(int i=0;i<n;i++)
        {
            last[s.charAt(i) - 'a'] = i;
            if(last[0] != -1 && last[1] != -1 && last[2] != -1)
            {
                int minIdx = Math.min(last[0],Math.min(last[1],last[2]));
                c+=minIdx+1;
            }
        }
        
        return c;
    }
}
        
