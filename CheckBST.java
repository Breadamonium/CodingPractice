//https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem
/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/

/* First solution I could think of for this problem, use recursive helper to check each 
node of tree recursively, if left or right exist, do comparison check to see if still valid, if not return false,
otherwise continue and check child nodes for same thing. Only half the test cases pass, so some corner case is missing,
will investigate further later. */

    boolean recursiveCheck(Node root) {
        if (root.left!=null) {
            if (root.left.data > root.data) {
                return false;
            }
            recursiveCheck(root.left);
        }
        if (root.right!=null) {
            if (root.right.data < root.data) {
                return false;
            }
            recursiveCheck(root.right);
        }
        return true;
    }
    boolean checkBST(Node root) {
        if (recursiveCheck(root) == false) {
            return false;
        }
        else {
            return true;
        }
    }
