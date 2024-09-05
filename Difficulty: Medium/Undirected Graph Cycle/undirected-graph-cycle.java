//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public static boolean cycleDetection(ArrayList<ArrayList<Integer>> adj, boolean[] visit, int curr, int par) {
        visit[curr] = true;
        for (int i = 0; i < adj.get(curr).size(); i++) {
            int e = adj.get(curr).get(i);
            if (!visit[e]) {
                if (cycleDetection(adj, visit, e, curr)) {
                    return true;
                }
            } else if (e != par) { // This condition should be outside the previous if block
                return true; // Detected a cycle
            }
        }

        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visit = new boolean[V]; // Should use V (the number of vertices) instead of adj.size()

        for (int i = 0; i < V; i++) { // Iterate over all vertices
            if (!visit[i]) {
                if (cycleDetection(adj, visit, i, -1)) { // Start DFS from vertex i
                    return true;
                }
            }
        }

        return false;
    }
}