/* Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        TreeNode marker=new TreeNode(0);
        q.add(marker);
        int index=0;
        res.add(new ArrayList<Integer>());
        int c=0;
        
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            
            if(temp==marker){
                if(c!=0){
                    q.add(marker);
                    c=0;
                    res.add(new ArrayList<Integer>());
                    index++;
                }
            }
            else{
                res.get(index).add(temp.val);
                
                if(temp.left!=null){
                  q.add(temp.left);
                    c++;
                } 
                if(temp.right!=null) {
                    q.add(temp.right);
                    c++;
                }
            }
        }
        
        List<List<Integer>> reverse = new ArrayList<>(res);
        Collections.reverse(reverse);
        return reverse;
    }
}
