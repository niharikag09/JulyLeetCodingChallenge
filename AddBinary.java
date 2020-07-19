/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.
*/
class Solution {
    public String addBinary(String a, String b) {
        
        int alen=a.length();
        int blen=b.length();
        
        if(alen<blen){
            
            for(int i=0;i<blen-alen;i++){
                a="0"+a;
            }
        }
        else if(blen<alen){
            for(int i=0;i<alen-blen;i++){
                b="0"+b;
            }
        }
        
        int carry=0;
        String res="";
        for(int i=a.length()-1;i>=0;i--){
            
            int sum=Character.getNumericValue(a.charAt(i))+Character.getNumericValue(b.charAt(i))+carry;
            res=Integer.toString(sum%2)+res;
           
            carry=sum>1?1:0;
        }
        
        if(carry==1) res="1"+res;
        
        return res;
    }
}
