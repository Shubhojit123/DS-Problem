//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            obj.printGfg(n);
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    public static void p(int i , int N)
    {
        if(i>N)
        {
            return;
        }
        System.out.print("GFG"+" ");
        p(i+1,N);
    }
    void printGfg(int N) {
        // code here
        int i = 0;
        p(i+1,N);
    }
}