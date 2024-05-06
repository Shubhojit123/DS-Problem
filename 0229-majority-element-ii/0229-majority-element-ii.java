class Solution {
    public List<Integer> majorityElement(int[] nums) {
            List<Integer> ans = new ArrayList<>();
        int el1 = 0;
        int el2 = -1;
        int cn1 =0;
        int cn2 = 0;
//             if(nums.length == 2 && nums[0] != nums[1])
//             {
//                     ans.add(nums[0]);
//                     ans.add(nums[1]);
                    
//                     return ans;
//             }
       
            for(int i=0;i<nums.length;i++)
            {
                if(cn1 == 0 && el2 !=nums[i])
                {
                        cn1 = 1;
                        el1 = nums[i];
                }
                    else if (cn2 == 0 && el1!=nums[i])
                    {
                          cn2 = 1;
                          el2 = nums[i];
                    }
                    else if (el1 == nums[i])
                    {
                            cn1++;
                    }
                    else  if (el2 == nums[i])
                    {
                            cn2++;
                    }
                    else
                    {
                            cn1--;
                            cn2--;
                    }
            }
            
            int ac1 = 0;
            int ac2 = 0;
            int mini = (int)(nums.length / 3) + 1;
            for(int i=0;i<nums.length;i++)
            {
                    if(el1 == nums[i])ac1++;
                    if(el2 == nums[i])ac2++;
            }
            
            if(ac1>=mini)
            {
                    ans.add(el1);
            }
             if(ac2>=mini)
            {
                    ans.add(el2);
            }
            return ans;
    }
}