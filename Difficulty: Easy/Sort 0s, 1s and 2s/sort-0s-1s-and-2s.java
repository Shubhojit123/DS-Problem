//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        // code here
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i) == 0)
            {
                count0++;
            }
            else if(arr.get(i)==1)
            {
                count1++;
            }
            else
            {
                count2++;
            }
        }
            int i = 0;


    while (count0 > 0) {
        arr.set(i++, 0);
        count0--;
    }


    while (count1 > 0) {
        arr.set(i++, 1);
        count1--;
    }

    while (count2 > 0) {
        arr.set(i++, 2);
        count2--;
    }

    }
}