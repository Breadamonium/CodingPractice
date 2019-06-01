//https://leetcode.com/problems/inorder-successor-in-bst/ #285
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        ArrayList<TreeNode> parents = new ArrayList<>();
        
        TreeNode current = root;
        while(current!=null || current!=p) {
            if (current.val > p.val) {
                parents.add(current);
                current = current.left;
            }
            else if (current.val < p.val) {
                parents.add(current);
                current = current.right;
            }
            else{
                parents.add(current);
                break;
            }
        }
        
        Queue<TreeNode> seenChildren = new LinkedList<>();
        seenChildren.add(p);
        while(!seenChildren.isEmpty()) {
            TreeNode pStart = seenChildren.poll();
            if (pStart.left!=null) {
                parents.add(pStart.left);
                seenChildren.add(pStart.left);
            }
            if (pStart.right!=null) {
                parents.add(pStart.right);
                seenChildren.add(pStart.right);
            }
        }
        int ans = Integer.MAX_VALUE;
        TreeNode answer = null;
        for (TreeNode x : parents) {
            if (x.val < ans && x.val > p.val) {
                ans = x.val;
                answer = x;
            }
        }
        return answer;
        
    }
}