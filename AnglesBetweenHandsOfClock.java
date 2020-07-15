/*
Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.
Example 1:
Input: hour = 12, minutes = 30
Output: 165
*/

class Solution {
    public double angleClock(int hour, int minutes) {
        
        double degree1minHourHand=(double)360/(12*60); //hourhand moves full 360 in 12 hours so how much degree in 1 min?
        double degree1minMinHand=360/60; //min hand moves 360 in 60 min so  how much degree in 1 min? 
        
        if(hour==12) hour=0;
        
        int totalMin=(hour*60)+minutes;
        
        double degreeHourHand=degree1minHourHand*totalMin;
        double degreeMinHand=degree1minMinHand*minutes;
         
        double diff=Math.abs(degreeHourHand- degreeMinHand);
        
        return Math.min(diff, 360-diff);
    }
}
