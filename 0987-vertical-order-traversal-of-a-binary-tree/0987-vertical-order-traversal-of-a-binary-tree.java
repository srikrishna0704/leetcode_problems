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
    static class Tuple {
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        // Map: col -> (row -> PriorityQueue of node values)
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple cur = queue.poll();
            TreeNode node = cur.node;
            int r = cur.row;
            int c = cur.col;

            map.putIfAbsent(c, new TreeMap<>());
            map.get(c).putIfAbsent(r, new PriorityQueue<>());
            map.get(c).get(r).offer(node.val);

            if (node.left != null) {
                queue.offer(new Tuple(node.left, r + 1, c - 1));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, r + 1, c + 1));
            }
        }

        for (Map<Integer, PriorityQueue<Integer>> rowsMap : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rowsMap.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            res.add(colList);
        }

        return res;
    }
}
class Pair{
    TreeNode node;
    int hd;
    Pair(TreeNode node,int hd){
        this.node=node;
        this.hd=hd;
    }
}