/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/find-bottom-left-tree-value/ #513
 class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> visited = new LinkedList<TreeNode>();
        
        visited.offer(root);
        TreeNode current = root;
        while(!visited.isEmpty()) {
            current = visited.poll();
            if (current.right!=null) {
                visited.offer(current.right);
            }
            if (current.left!=null) {
                visited.offer(current.left);
            }
        }
        return current.val;
    }
}

//[2, 1, 3] -> 2, 3, 1
//[1, 2, 3, 4, 5, 6, 7] -> 1, 3, 2, 6, 5, 4, 7