class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c = 0;
        int ms = 0 ;
        for(int i = 0 ;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                c++;
                ms = Math.max(ms,c);
            }
            else
            {
                c=0;
            }
        }
        return ms;
    }
}