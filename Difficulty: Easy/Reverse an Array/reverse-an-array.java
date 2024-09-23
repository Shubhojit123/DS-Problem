//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String str[] = br.readLine().split(" ");
            int arr[] = new int[str.length];

            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            Solution obj = new Solution();

            obj.reverseArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    public static void rev(int arr[],int l ,int h)
    {
        if(l>=h)
        {
            return;
        }
        
        int temp = arr[l];
        arr[l] = arr[h];
        arr[h] = temp;
        
        rev(arr,l+1,h-1);
    }
    public void reverseArray(int arr[]) {
        // code here
        rev(arr,0,arr.length-1);
    }
}