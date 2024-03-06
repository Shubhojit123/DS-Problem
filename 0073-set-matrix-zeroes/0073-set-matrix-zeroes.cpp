class Solution {
public:
    void setZeroes(vector<vector<int>>&a) {
         int n = a.size();
        int m = a[0].size();

        // Initialize vectors to store rows and columns with zeroes
        vector<int> col(m, 0);
        vector<int> r(n, 0);

        // Mark rows and columns with zeroes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    r[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Set elements to zero based on marked rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (r[i] == 1 || col[j] == 1) {
                    a[i][j] = 0;
                }
            }
        }
    }
};