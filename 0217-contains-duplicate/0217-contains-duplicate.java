class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> st = new HashSet<Integer>(); 
        for(int i=0;i<nums.length;i++)
        {
            if(!st.add(nums[i]))
            {
                return true;
            }
            
        }
        return false;
    }
}