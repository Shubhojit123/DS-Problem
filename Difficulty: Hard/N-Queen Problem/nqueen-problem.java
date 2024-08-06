//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
     
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public static boolean isSafe(char box[][],int row , int column)
    {
      for (int i = row - 1; i >= 0; i--) {
            if (box[i][column] == 'Q') {
                return false;
            }
        }
        
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (box[i][j] == 'Q') {
                return false;
            }
        }
        
        for (int i = row - 1, j = column + 1; i >= 0 && j < box.length; i--, j++) {
            if (box[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
    public static void solve( char box[][],int i )
    {
        if(i == box.length)
        {
          adding(box);
            return;
        }
        
            for(int j = 0 ; j < box.length ; j++)
            {
                if(isSafe(box,i,j))
                {
                    box[i][j] = 'Q';
                    solve(box,i+1);
                    box[i][j] = '.';
                }
            }
    }
 public static void adding(char[][] box) {
        ArrayList<Integer> solution = new ArrayList<>();
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box.length; j++) {
                if (box[i][j] == 'Q') {
                    solution.add(j + 1); 
                }
            }
        }
        ans.add(solution);
    }

    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ans.clear();
        char box[][] = new char[n][n];
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                box[i][j] = '.';
            }
        }
        solve(box,0);
        return ans;
        
    }
}