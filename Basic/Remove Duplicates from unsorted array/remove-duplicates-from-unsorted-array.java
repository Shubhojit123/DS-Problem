//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            int getAnswer[] = obj.removeDuplicate(a, n);
            int sz = getAnswer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(getAnswer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java



class Solution {
    
    public int[] removeDuplicate(int A[], int N)
    {
        Set<Integer>st = new LinkedHashSet<>();
        
        for(int i=0;i<N;i++)
        {
            st.add(A[i]);
        }
        int [] ans = new int[st.size()];
        int i=0;
        for(int j:st)
        {
            ans[i++] = j;
        }
        return ans;
    }
}