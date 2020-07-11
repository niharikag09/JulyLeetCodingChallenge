/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res=new ArrayList<>();
        
        res.add(new ArrayList<Integer>()); // start with empty
        
        for(int i=0;i<nums.length;i++){
            
            int size=res.size();
            // for each existing arraylist add the new element from given array
            for(int j=0;j<size;j++){
                
                List<Integer> temp=new ArrayList<Integer>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        
        return res;
    }
}
