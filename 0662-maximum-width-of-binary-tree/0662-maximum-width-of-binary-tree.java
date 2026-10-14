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

public class Pair{
    TreeNode node;
    long index;
    Pair(TreeNode node,long index){
        this.node=node;
        this.index=index;
    }

}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int minWidth=0;
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            int size=queue.size();
            long minIndex=queue.peek().index;
            long first=0;
            long last=0;
            for(int i=0;i<size;i++){
                Pair cur =queue.poll();
                TreeNode node=cur.node;
                long cur_id=cur.index- minIndex;
                if(i==0)first=cur_id;
                if(i==size-1)last=cur_id;
                if(node.left!=null)queue.offer(new Pair(node.left,(2*cur_id+1)));
                if(node.right!=null)queue.offer(new Pair(node.right,(2*cur_id+2)));
            }
            minWidth=Math.max(minWidth,(int)(last-first+1));
        }
        return minWidth;
    }
}