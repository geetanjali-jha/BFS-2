// Time complexity:- 0(n)
// Space complexity:- 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * Approach:
 * 
 *  
 */ 
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return result;
        }

        queue.add(root);

        while(!queue.isEmpty()) {
        
            List<Integer> tempArr = new ArrayList<>();
            int size = queue.size();

            for(int i = 0; i < size; i++) {

                TreeNode curNode = queue.remove();

                tempArr.add(curNode.val);

                if(curNode.left != null) {
                    queue.add(curNode.left);
                }
                if(curNode.right != null) {
                    queue.add(curNode.right);
                }                
            }
           
            result.add(tempArr.get(tempArr.size() - 1));
        }
        return result;
     }
}