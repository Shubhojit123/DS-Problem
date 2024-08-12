//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        
        ArrayList<Integer> st = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        int n = arr1.length;
        
            while( i<n && j<n)
        {
            if(arr1[i] < arr2[j])
            {
                st.add(arr1[i]);
                i++;
            }
            else
            {
                st.add(arr2[j]);
                j++;
            }
        }
        
        while(i<n)
        {
            st.add(arr1[i++]);
        }
        
        while(j<n)
        {
            st.add(arr2[j++]);
        }
        
        int mid = st.size()/2;;
        
        int ans = st.get(mid) + st.get(mid-1);
    
        
        return ans;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends