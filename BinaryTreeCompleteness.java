//https://leetcode.com/problems/check-completeness-of-a-binary-tree/ #958

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> seen = new LinkedList<>();
        TreeNode current = root;
        seen.add(current);
        while(!seen.isEmpty()){
            current = seen.poll();
            if (current == null) {
                while(!seen.isEmpty()) {
                    current = seen.poll();
                    if (current != null) {
                        return false;
                    }
                }
            }
            else{
                seen.add(current.left);
                seen.add(current.right);
            }
        }
        return true;
    }
}