/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> list=new ArrayList<>();
        
        if(root==null) return list;
        
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        
        stack1.push(root);
        
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            
            ArrayList<Integer> ar=new ArrayList<>();
            
            while(!stack1.isEmpty()){
                
                TreeNode temp=stack1.pop();
                            
                ar.add(temp.val);
                
                if(temp.left!=null) stack2.push(temp.left);
                if(temp.right!=null) stack2.push(temp.right);
            }
            
            if(ar.size()!=0) list.add(ar);
            
            ArrayList<Integer> arr=new ArrayList<>();
            
            while(!stack2.isEmpty()){
                
                TreeNode temp=stack2.pop();
                arr.add(temp.val);
                
                if(temp.right!=null) stack1.push(temp.right);
                 if(temp.left!=null) stack1.push(temp.left);
            }
            
            if(arr.size()!=0) list.add(arr);
            
        }
        
        return list;
    }
}
