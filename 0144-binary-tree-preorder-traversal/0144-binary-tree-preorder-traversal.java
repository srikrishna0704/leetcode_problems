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
    public void PreOrder(TreeNode node,List<Integer> res){
        if(node==null){
            return;
        }
        res.add(node.val);
        PreOrder(node.left,res);
        PreOrder(node.right,res);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        PreOrder(root,res);
        return res;
    }
}