//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] coins = IntArray.input(br, N);
            
            Solution obj = new Solution();
            boolean res = obj.isPossible(N, coins);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends



class Solution{
    boolean isPossible(int N, int[] coins){
    int total = Arrays.stream(coins).sum();
    boolean[][] possibility = new boolean[N + 1][total + 1];
    for (int i = 0; i <= N; i++) {
        possibility[i][0] = true;
    }
    for (int i = 1; i <= total; i++) {
        possibility[0][i] = false;
    }
    for (int idx = 1; idx <= N; idx++) {
        for (int sum = 1; sum <= total; sum++) {
            if (sum < coins[idx - 1]) {
                possibility[idx][sum] = possibility[idx - 1][sum];
            }
            if (sum >= coins[idx - 1]) {
                possibility[idx][sum] = possibility[idx - 1][sum] || possibility[idx - 1][sum - coins[idx - 1]];
            }
        }
    }
    for (int sum = 1; sum <= total; sum++) {
        if ((sum % 20 == 0 || sum % 24 == 0 || sum == 2024) && possibility[N][sum]) {
            return true;
        }
    }
    return false;
}
}
        
