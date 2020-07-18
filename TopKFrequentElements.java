/*

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.

*/

class Solution {
    
    class Element{
        int val;
        int freq;
        
        Element(int val, int freq){
            this.val=val;
            this.freq=freq;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        
        PriorityQueue<Element> pq=new PriorityQueue<>(k, new Comparator<Element>(){
           
            public int compare(Element a, Element b){
                return (a.freq-b.freq);
            }
        });
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            
            if(!map.containsKey(nums[i])) map.put(nums[i],0);
            
            map.put(nums[i],map.get(nums[i])+1);
        }
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            pq.add(new Element(entry.getKey(), entry.getValue()));
            if(pq.size()>k) pq.poll();
        }
        
        int[] res=new int[k];
        
        for(int i=0;i<k;i++){
            Element e=pq.poll();
            res[i]=e.val;
        }
        
        return res;
    }
}
