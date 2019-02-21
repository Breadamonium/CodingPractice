//#776 http://leetcode.com/problems/split-bst/

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
    TreeNode greaterSideRoot = null;
    TreeNode lesserSideRoot = null;
    TreeNode[] answer = new TreeNode[2];
    answer[0] = lesserSideRoot;
    answer[1] = greaterSideRoot;
    
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode curr = root;
        if (curr == null) {
            return answer;
        }
        
        if (curr.val > val) {
            TreeNode[] leftSubTree = splitBST(curr.left, V);
            curr.left = leftSubTree[1];
        }
        else {
            lesserSideRoot = curr;
            helper(curr.left);
        }
    }
}