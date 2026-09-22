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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        ListNode back = head;
        ListNode front = head;
        for(int i = 0;i<n;i++){
            front = front.next;
        }
        ListNode prev = null;
        while(front!=null){
            prev = back;
            back = back.next;
            front=front.next;
        }
        if(prev==null){
            head=head.next;
        }else{
        prev.next = back.next;}
        return head;
    }
}
