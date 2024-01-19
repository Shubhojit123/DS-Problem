class Solution {
    public int majorityElement(int[] nums) {
        int c=0;
        int ansc=0;
        int el=0;
        for(int i=0;i<nums.length;i++)
        {
            if(c==0)
            {
                c++;
                el=nums[i];
            }
            else if(el==nums[i])
            {
                c++;
            }
            else if(el!=nums[i])
            {
                c--;
            }
        }
        for(int i=0;i<nums.length-1;i++)
        {
            if(el==nums[i])
            {
                ansc++;
            }
        }
        if(ansc >= nums.length/2)
        {
            return el;
        }
        return -1;
    }
}