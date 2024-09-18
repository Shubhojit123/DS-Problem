//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(n, arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String printLargest(int n, String[] arr) {
        // code here
        
         Arrays.sort(arr,new Comparator<String>()
                        {
                                public int compare(String a , String b)
                                {
                                        String ft = a+b;
                                        String lt = b+a;
                                        
                                        return lt.compareTo(ft);
                                }
        });
        
        StringBuilder sb = new StringBuilder();
            
            for(String val : arr)
            {
                    sb.append(val);
            }
            
            return sb.toString();
    }
}