//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean cycleUtility(ArrayList<ArrayList<Integer>> adj,boolean [] visit, boolean stack[],int curr)
    {
        visit[curr] = true;
        stack[curr] = true;
        for(int i=0;i<adj.get(curr).size();i++)
        {
            int dest = adj.get(curr).get(i);
            if(stack[dest])
            {
                return true;
            }
            else if(!visit[dest])
            {
                if(cycleUtility(adj,visit,stack,dest))
                {
                     return true;                    
                }

            }
            
        }
                 stack[curr] = false;
                 return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visit[] = new boolean[V];
        boolean stack[] = new boolean[V];
        
        for(int i=0;i<V;i++)
        {
            if(!visit[i])
            {
                if(cycleUtility(adj,visit,stack,i))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
}