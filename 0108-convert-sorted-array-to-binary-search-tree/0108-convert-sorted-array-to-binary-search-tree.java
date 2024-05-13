/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
              return arr(nums,0,nums.length-1);
    }
        public static TreeNode arr(int nums[] , int si , int ei)
        {
                 if(si>ei)
                {
                    return null;
                }
             int mid = (si+ei)/2;
             TreeNode root = new TreeNode(nums[mid]);
             root.left = arr(nums,si,mid-1);
             root.right = arr(nums,mid+1,ei);
                
                return root;
        }
}