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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return inPreTree(map,preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode inPreTree(Map<Integer,Integer> map,int[] preorder, int pres,int pree,int[] inorder,int ins,int ine){
        if(pres>pree || ins>ine)return null;
        TreeNode root=new TreeNode(preorder[pres]);
        int inroot=map.get(root.val);
        int numslength=inroot-ins;
        root.left= inPreTree(map,preorder,pres+1,pres+numslength,inorder,ins,inroot-1);
        root.right= inPreTree(map,preorder,pres+numslength+1,pree,inorder,inroot+1,ine);
        return root;
    }
}