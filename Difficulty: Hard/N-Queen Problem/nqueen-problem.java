//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
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

class Solution {
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public static boolean isSafe(char[][] q, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (q[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (q[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < q.length; i--, j++) {
            if (q[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void help(char[][] q, int row, int n) {
        // If all queens are placed
        if (row == n) {
            add(q);
            return;
        }

        // Try placing a queen in all columns one by one
        for (int col = 0; col < n; col++) {
            if (isSafe(q, row, col)) {
                q[row][col] = 'Q';  // Place the queen
                help(q, row + 1, n); // Recur to place rest of the queens
                q[row][col] = '.';   // Backtrack
            }
        }
    }
    public static void add(char [][] q )
    {
         ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < q.length; i++) {
            for (int j = 0; j < q.length; j++) {
                if (q[i][j] == 'Q') {
                    al.add(j + 1);
                }
            }
        }

        ans.add(al);
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ans.clear();
        char [][]q = new char[n][n];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                q[i][j] = '.';
            }
        }
        
        help(q,0,n);
        
        return ans;
    }
}