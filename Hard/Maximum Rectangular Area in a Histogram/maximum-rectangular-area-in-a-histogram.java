//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
       
       long left[]=new long[(int)n];
        long right[]=new long[(int)n];
        
        Stack<Integer>stk=new Stack<>();
        for(int i=0;i<(int)n;i++){
            
            while(!stk.isEmpty() && hist[stk.peek()]>=hist[i]) stk.pop();
            
            
            if(stk.isEmpty()) left[i]=0;
            else{
                left[i]=stk.peek()+1;
            }
            stk.push(i);
            
        }
        while(!stk.isEmpty())stk.pop();
        
        for(int i=(int)n-1;i>=0;i--){
            
            while(!stk.isEmpty() && hist[stk.peek()]>=hist[i])stk.pop();
            if(stk.isEmpty())right[i]=n-1;
            else{
                right[i]=stk.peek()-1;
            }
            stk.push(i);
        }
         long MaxArea = 0;
     for(int i = 0; i < (int)n; i++){
    MaxArea = Math.max(MaxArea, (right[i] - left[i] + 1) * hist[i]);
       }
return MaxArea; 

    }
        
}



