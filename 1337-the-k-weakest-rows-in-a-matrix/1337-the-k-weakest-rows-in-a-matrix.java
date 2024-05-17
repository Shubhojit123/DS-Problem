import java.util.PriorityQueue;

class Solution {
 public static class Row implements Comparable<Row> {
        int sol;
        int idx;

        public Row(int sol, int idx) {
            this.idx = idx;
            this.sol = sol;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.sol == r2.sol) {
                return this.idx - r2.idx;
            } else {
                return this.sol - r2.sol;
            }
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
            int ans[] = new int[k];
            PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i = 0 ;i<mat.length;i++)
        {
                int c = 0;
               for (int j = 0; j < mat[0].length; j++)
                {
                        c += mat[i][j] == 1 ? 1 :0;
                }
                pq.add(new Row(c , i));
        }
            
            for(int i = 0 ; i<k;i++)
            {
                    ans[i] = pq.remove().idx;
            }
            return ans;
    }
}