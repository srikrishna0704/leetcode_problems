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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return inPost(map,inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    } 
    public TreeNode inPost(Map<Integer,Integer> map,int[] inorder,int ins,int ine,int[] postorder,int pos, int poe){
        if(pos>poe || ins>ine)return null;
        TreeNode root=new TreeNode(postorder[poe]);
        int inroot=map.get(root.val);
        int numslength=inroot-ins;
        root.left= inPost(map,inorder,ins,inroot-1,postorder,pos,pos+numslength-1);
        root.right= inPost(map,inorder,inroot+1,ine,postorder,pos+numslength,poe-1);
        return root;
    }
}