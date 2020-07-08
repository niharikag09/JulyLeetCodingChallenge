/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res=new ArrayList<>();
        
        //for adding distint arrays in the result
        HashSet<List<Integer>> result= new HashSet<>();
        
        if(nums.length==0) return res;
        
        HashSet<Integer> set=new HashSet<>();
        
        //sorting so that order is always same and set can detect a duplicate
        Arrays.sort(nums);
        set.add(nums[0]);
        
        for(int i=1;i<nums.length;i++){
            
            int a=nums[i];
            boolean found=false;
            for(int j=i+1;j<nums.length;j++){
                int b=nums[j];
                int c=0-(a+b);
                
                if(set.contains(c)){
                    ArrayList<Integer> ar=new ArrayList<>();
                    ar.add(c);
                    ar.add(a);
                    ar.add(b);
                    
                    result.add(ar);
                   
                }
            }
        
                set.add(a);
        }
        
        //converting result set into list
        for(List<Integer> list:result){
            res.add(list);
        }
        
        return res;
    }
}
