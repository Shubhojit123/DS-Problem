//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Searching
{
    public static void main (String[] args)throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
           String a[] = read.readLine().trim().split("\\s+");
           int n = Integer.parseInt(a[0]);
           long x = Long.parseLong(a[(int)1]);
           String st[] = read.readLine().trim().split("\\s+");
        
           long arr[] = new long[n];
           for(int i = 0; i < n; i++)
           {
               arr[i] = Long.parseLong(st[i]);
           }
           
           out.println(new Solution().findFloor(arr, n, x));
          
        }
        out.close();
    }
    
}
// } Driver Code Ends


class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long a[], int n, long x)
    {
        int low =0;
        int high =n-1;
        int ans =-1;
        if(a[0]>x)
        {
            return -1;
        }
        
        while(low<=high)
        {
            int mid = (low+high)/2;
            
            if(a[mid]==x)
            {
            return mid;
            }
            else if(x>a[mid])
            {
                low = mid+1;
                ans = mid;
            }
            else
            {
                high = mid-1;
            }
        }

        return ans;
    }
    
}
