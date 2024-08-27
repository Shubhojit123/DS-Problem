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
            int N = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            obj.printNos(N);
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    public static void p(int i , int N)
    {
        if(i < 1)
        {
            return;
        }
        System.out.print(i+" ");
        p(i-1,N);
    }
    void printNos(int N) {
        // code here
        int i = N;
        p(i,N);
    }
}