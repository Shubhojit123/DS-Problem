//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
     public static int lastOccurence(int nums[],int n , int x)
    {
        int low = 0;
        int high = n-1;
        int fo=-1;
        while(low<= high)
        {
            int mid = (low+high)/2;
            if(nums[mid] == x)
            {
                fo = mid;
                low = mid+1;
            }
            else if(nums[mid] > x)
            {
                high = mid-1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        return fo;
    }
    public static int firstOccurence(int nums[],int n , int x)
    {
        int low = 0;
        int high = n-1;
        int fo=-1;
        while(low<= high)
        {
            int mid = (low+high)/2;
            if(nums[mid] == x)
            {
                fo = mid;
                high = mid-1;
            }
            else if(nums[mid] > x)
            {
                high = mid-1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        return fo;
    }
    ArrayList<Integer> find(int nums[], int n, int x)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int fo = firstOccurence(nums,n,x);
        int lo = lastOccurence(nums,n,x);
        if( fo == 1)
        {
            ans.add(-1);
            ans.add(-1);
            
            return ans;
        }
        
        ans.add(fo);
        ans.add(lo);
        
        return ans;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends