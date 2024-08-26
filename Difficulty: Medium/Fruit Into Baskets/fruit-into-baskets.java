//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalFruits(arr);
            System.out.println(ans);
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(Integer[] arr) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int n = arr.length;
        int maxLen = 0;
        while(r<n)
        {
            int i = 0;
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            
            if(map.size()>2)
            {
                map.put(arr[l], map.get(arr[l]) - 1);
                if(map.get(arr[l]) == 0)
                {
                    map.remove(arr[l]);
                }
                l++;
            }
            if(map.size()<=2)
            {
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        
        return maxLen;
    }
}