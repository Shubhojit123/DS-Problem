//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    long floorSqrt(long n) {
        // Your code here
        
        // long high = n ;
        // long low = 1;
        // long mid = (low+high) / 2;
        // long val = mid*mid;
        
        // while(high > low)
        // {
        //     if(val <= n)
        //     {
        //         low = mid + 1;
        //     }
        //     else
        //     {
        //         high = mid - 1;
        //     }
        // }
        
        // return high;
        long  ans = 1;
        for(long i = 1 ; i < n; i++)
        {
            if(i*i <= n)
            {
                ans = i;   
            }
            else
            {
                break;
            }
        }
        
        return ans;
    }
}
