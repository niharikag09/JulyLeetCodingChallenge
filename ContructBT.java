/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
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
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        return construct(0, inorder.length-1,inorder,0, postorder.length-1 , postorder);
    }
    
    private TreeNode construct(int instart, int inend, int[] inorder, int pstart, int pend, int[] postorder){
        
        if(instart>inend || pstart>pend ) return null;
        
        int rootval=postorder[pend];
        
        TreeNode root=new TreeNode(rootval);
        
        int rootindex=search(instart, inend, rootval, inorder);
        
        int leftlen=rootindex-instart;
        int rightlen=inend-rootindex;
            
        root.right=construct(rootindex+1, inend, inorder, pend-rightlen, pend-1, postorder);
        root.left=construct(instart,rootindex-1, inorder, pstart, pstart+leftlen-1 , postorder);
        
        return root;
    }
    
    private int search(int start, int end, int rootval, int[] inorder){
        
        for(int i=start;i<=end;i++){
            if(inorder[i]==rootval) return i;
        }
        
        return -1;
    }
}
