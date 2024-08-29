//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] nums = IntArray.input(br, n);
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.countSubarray(n, nums, k);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int help(int [] nums , int k)
        {
        int r = 0;
        int l = 0;
        int n = nums.length;
        int sum = 0;
        int maxLen = 0;
            while(r<n)
            {
                    sum += nums[r]%2;
                    while(sum>k)
                    {
                           sum -= nums[l]%2;
                            l++;
                    }
                    
                    maxLen += (r-l+1);
                    r++;
            }
            
            return maxLen;
    }
    public static int countSubarray(int n, int[] nums, int k) {
        // code here
        
        return help(nums,k) - help(nums,k-1);
    }
}
        
