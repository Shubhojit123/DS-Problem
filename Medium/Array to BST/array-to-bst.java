//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
 class Node 
{
    int data;
    Node left = null;
    Node right = null;
    
    Node (int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution

{
    int ans[] ;
    int i =0;
    public Node bst(int nums[] , int si , int ei)
    {
         if(si>ei)
        {
            return null;
        }
        int mid = (si+ei)/2;
        Node root = new Node(nums[mid]);
        
        root.left = bst(nums,si,mid-1);
        root.right = bst(nums,mid+1,ei);
        return root;
    }

    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
      ans = new int [nums.length];
      Node p =  bst(nums,0,nums.length-1);
       pre(p);
      return ans;
    }
    
    public void pre(Node p)
    {
       
        
        if(p == null)
        {
            return;
        }
        ans[i++] = p.data;
          
        pre(p.left);
      
        pre(p.right);
    }
    
}