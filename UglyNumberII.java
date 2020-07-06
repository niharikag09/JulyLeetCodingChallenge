/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
*/
class Solution {
    public int nthUglyNumber(int n) {
        
        if(n<=1) return n;
        
        int l1=2; 
        int l2=3;
        int l3=5;
        
        int index1=0;
        int index2=0;
        int index3=0;
        
        ArrayList<Integer> ar=new ArrayList<>();
        ar.add(1);
        
        int curr=0;
        while(ar.size()<n){
             
            curr=Math.min(l1,Math.min(l2,l3));
            ar.add(curr);
            
            if(curr==l1){
                index1++;
                l1=ar.get(index1)*2;
            }
            if(curr==l2){
                index2++;
                l2=ar.get(index2)*3;
            }
            if(curr==l3){
                index3++;
                l3=ar.get(index3)*5;
            }
        }
        
        return ar.get(n-1);
        
    }
}
