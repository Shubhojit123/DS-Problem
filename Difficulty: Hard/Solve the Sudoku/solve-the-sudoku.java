//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku.
    public static boolean isSafe(int grid[][],int row , int col , int digit)
    {
        for(int i = 0 ; i<=8;i++)
        {
            if(grid[row][i] == digit)
            {
                return false;
            }
        }
        
        for(int j = 0 ; j<=8;j++)
        {
            if(grid[j][col] == digit)
            {
                return false;
            }
        }
        
        int sr = (row/3) * 3;
        int sc = (col/3) *3;
        
       for (int i = sr; i <= sr + 2; i++) {
            for (int j = sc; j <= sc + 2; j++) {
                if (grid[i][j] == digit) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static boolean helper(int grid[][],int row , int col)
    {
        if(row == 9 && col == 0)
        {
            return true;
        }
        int newRow = row;
        int newCol = col+1;
        if(newCol >= 9)
        {
            newRow = row+1;
            newCol = 0;
        }
        if(grid[row][col] != 0)
        {
            return helper(grid,newRow,newCol);
        }
        for(int digit = 1 ; digit<=9; digit++)
        {
            if(isSafe(grid,row,col,digit))
            {
                grid[row][col] = digit;
                if(helper(grid,newRow,newCol))
                {
                    return true;
                }
                grid[row][col]=0;
            }
        }
        
        return false;
    }
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        if(helper(grid,0,0))
        {
            return true;
        }
        else
        {
            System.out.print("False");
            return false;
        }
        
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int i  = 0 ; i<9 ; i++)
        {
            for(int j = 0 ; j <9 ; j++)
            {
                if(i <= 8 && j<=8)
                {
                System.out.print(grid[i][j]+" ");
                }
            }
        }
    }
}