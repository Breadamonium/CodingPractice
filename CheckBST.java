//https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem
/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/

/* Previous solution did not account for the corner case in which a node in a sub-left-subright value was greater than 
the root. My solution did not take into account of that and thus needs to run a max/min tracker to keep track of the 
largest and smallest value a subnode can be so it does not violate a previous root value.*/

/* Example Corner Case Tree: 4 is greater than 3 despite being in a left subtree, it is greater than 2 which is valid.
          3
       /    \   
      2      6
     / \    / \
    1   4  5   7
*/

//Easy solution from geeksforgeeks.com
    boolean recursiveCheck(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
 
        return (recursiveCheck(root.left, min, root.data-1) &&
                recursiveCheck(root.right, root.data+1, max));
    }
    boolean checkBST(Node root) {
        return recursiveCheck(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
