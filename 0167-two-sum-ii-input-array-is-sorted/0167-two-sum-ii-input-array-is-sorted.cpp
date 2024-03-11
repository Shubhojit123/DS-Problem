class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int lp = 0;
        int rp = numbers.size()-1;
        
        // int ans[2];
        while(lp<rp)
        {
            int sum =numbers[lp]+numbers[rp];
            if(sum==target)
            {
//                 ans[0] = lp;
//                 ans[1] = rp;
                
                return {lp+1,rp+1};
            }
            else if(sum<target)
            {
                lp++;
            }
            else
            {
                rp--;
            }
        }
        
        return {};
        
    }
};