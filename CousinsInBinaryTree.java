// Time complexity:- 0(n)
// Space complexity:- 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * Approach:
 * This problem is about checking if two nodes in a binary tree are cousins or not, meaning they have the same depth but different parents.
 * I used a level-order traversal (BFS) with two queues: one for the child nodes and another for their corresponding parent nodes.
 * By processing each level, I check if both nodes are found at the same depth with different parents, and return `true` if they are 
 * cousins, or false otherwise. 
 */ 
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        // Queue to hold the children nodes 
        Queue<TreeNode> childrenQueue = new LinkedList<>();

        //Queue to hold the parent nodes
        Queue<TreeNode> parent = new LinkedList<>();

        // Start the level-order traversal with the root node. The root node has no parent, so null is added for the parent.
        childrenQueue.add(root);
        parent.add(null);

        while(!childrenQueue.isEmpty()) {

            // Get the number of nodes at the current level.
            int size = childrenQueue.size();

            // Boolean to check if we have found both x and y nodes at this level.
            boolean x_found = false;
            boolean y_found = false;

            // Variables to store the parents of x and y if found.
            TreeNode x_parent = null;
            TreeNode y_parent = null;

            // Traverse all nodes at the current level.
            for(int i = 0; i < size; i++) {

                // Get the current child node and its parent.
                TreeNode childNode = childrenQueue.remove();
                TreeNode parentNode = parent.remove();

                // Check if the current child node is the one we are looking for (x).
                if(childNode.val == x) {
                    x_found = true;
                    x_parent = parentNode;
                }

                // Check if the current child node is the one we're looking for (y).
                if(childNode.val == y) {
                    y_found = true;
                    y_parent = parentNode;
                }

                // If the current child node has a left child, add it to the queue and set its parent.
                if(childNode.left != null) {
                    childrenQueue.add(childNode.left);
                    parent.add(childNode);
                }

                // If the current child node has a right child, add it to the queue and set its parent.
                if(childNode.right != null) {
                    childrenQueue.add(childNode.right);
                    parent.add(childNode);
                }
            }
            // If both x and y are found at this level:
            if(x_found == true && y_found == true) {
                return x_parent != y_parent;
            }
            // If only one of x or y is found at this level, return false because they cannot be cousins.
            if(x_found == true || y_found == true) {
                return false;
            }
        }
        // If neither x nor y is found, return false means the tree does not have both nodes.
        return false;
    }
}