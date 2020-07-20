/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        if(head==null) return head;
        
        ListNode curr=head;
        ListNode prev=null;
        
        while(curr!=null){
            
            if(curr.val==val){
                
                if(curr==head){
                    head=curr.next;
                    curr.next=null;
                    curr=head;
                }
                else{
                    ListNode next=curr.next;
                    prev.next=next;
                    curr.next=null;
                    curr=next;
                }
            }
            else{
                prev=curr;
                curr=curr.next;
            }
        }
        
        return head;
    }
}
