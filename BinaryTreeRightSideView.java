//https://leetcode.com/problems/binary-tree-right-side-view/
//#199
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<Integer>();
        if (root == null) {
            return answer;
        }
        Queue<TreeNode> toProcess = new LinkedList<TreeNode>();
        toProcess.add(root);
        while(!toProcess.isEmpty()) {
            int size = toProcess.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = toProcess.poll();
                if(i == 0) {
                    answer.add(current.val);
                }
                if(current.right!=null){
                    toProcess.add(current.right);
                }
                if(current.left!=null){
                    toProcess.add(current.left);
                }
            }   
        }
        
        return answer;
    }
}