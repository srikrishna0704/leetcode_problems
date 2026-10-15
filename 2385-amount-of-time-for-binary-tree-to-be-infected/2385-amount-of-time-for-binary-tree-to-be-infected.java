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
    public static TreeNode parentFinding(TreeNode root,Map<TreeNode,TreeNode> parentMap,int start){
        Queue<TreeNode> q1=new LinkedList<>();
        TreeNode targetNode=null;
        q1.offer(root);
        while(!q1.isEmpty()){
            TreeNode cur=q1.poll();
            if(cur.val==start){
                targetNode=cur;
            }
            if(cur.left!=null){
                q1.offer(cur.left);
                parentMap.put(cur.left,cur);
            }
            if(cur.right!=null){
                q1.offer(cur.right);
                parentMap.put(cur.right,cur);
            }
        }
        return targetNode;

    }
    public int findTime(TreeNode target,Map<TreeNode,TreeNode> parentMap ){
        Queue<TreeNode> queue =new LinkedList<>();
        Set<TreeNode> visited=new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int time=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            boolean burn=false;
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if(cur.left!=null && !visited.contains(cur.left)){
                    queue.offer(cur.left);
                    visited.add(cur.left);
                    burn=true;
                }
                if(cur.right!=null && !visited.contains(cur.right)){
                    queue.offer(cur.right);
                    visited.add(cur.right);
                    burn=true;
                }
                TreeNode parent=parentMap.get(cur);
                if(parent!=null && !visited.contains(parent)){
                    queue.offer(parent);
                    visited.add(parent);
                    burn=true;
                }
            }
            if(burn)time++;
        }
        return time;
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode , TreeNode> parentMap=new HashMap<>();
        TreeNode node=parentFinding(root,parentMap,start);
        return findTime(node,parentMap);
    }
}