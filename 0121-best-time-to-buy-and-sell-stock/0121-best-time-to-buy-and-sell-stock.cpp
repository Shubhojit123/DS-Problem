class Solution {
public:
    int maxProfit(vector<int>& a) {
         int mini = a[0];
        int profit = 0;
        int cost =0;
        for(int i=1;i<a.size();i++)
        {
            cost = a[i] - mini;
            profit = max(cost,profit);
            mini = min(mini,a[i]);
        }
        return profit;
    }
};