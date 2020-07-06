/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
*/
class Solution {
    public int hammingDistance(int x, int y) {
        String xbin=convertToBinary(x);
        String ybin=convertToBinary(y);
        
        int xlen=xbin.length();
        int ylen=ybin.length();
        
        if(xlen<ylen){
            
            for(int i=0;i<ylen-xlen;i++){
                xbin="0"+xbin;
            }
        }
        else{
           for(int i=0;i<xlen-ylen;i++){
                ybin="0"+ybin;
            } 
        }
        
        xlen=xbin.length();
        int count=0;
        
        for(int i=0;i<xlen;i++){
            if(xbin.charAt(i)!=ybin.charAt(i)) count++;
        }
        
        return count;
    }
    
    private String convertToBinary(int n){
        String binary="";
        while(n>1){
            int temp=n%2;
            binary=Integer.toString(temp)+binary;
            n=n/2;
        }
        
        return Integer.toString(n)+binary;
    }
}
