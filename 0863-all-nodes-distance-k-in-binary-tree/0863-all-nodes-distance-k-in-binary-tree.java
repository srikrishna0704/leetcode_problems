/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void mappingParent(TreeNode node,Map<TreeNode , TreeNode> parentMap){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentMap=new HashMap<>();
        mappingParent(root,parentMap);
        Queue<TreeNode> queue=new LinkedList<>();
        Set<TreeNode> visited=new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int curDistance=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            if(curDistance==k)break;
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
    
                // left check
                if(cur.left!=null && !visited.contains(cur.left)){
                    queue.offer(cur.left);
                    visited.add(cur.left);
                }
                // right check
                if(cur.right!=null && !visited.contains(cur.right)){
                    queue.offer(cur.right);
                    visited.add(cur.right);
                }
                TreeNode parent=parentMap.get(cur);
                if(parent!=null && !visited.contains(parent)){
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
            curDistance++;
        }
        List<Integer> res=new ArrayList<>();
        while(!queue.isEmpty()){
            res.add(queue.poll().val);
        }
        return res;
    }
}