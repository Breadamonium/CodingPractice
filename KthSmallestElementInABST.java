import java.util.ArrayList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/ #230
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
    ArrayList<Integer> minimums = new ArrayList<Integer>();

    public int kthSmallest(TreeNode root, int k) {
        TreeNode current = root;
        inOrderTraversal(current);
        return minimums.get(k-1);
    }

    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        minimums.add(node.val);
        inOrderTraversal(node.right);
    }
}