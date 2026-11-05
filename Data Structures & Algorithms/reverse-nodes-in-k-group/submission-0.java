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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prevGroup = dummy;
        while(true){
            ListNode kth = prevGroup;
            for(int i = 0; i < k && kth!=null; i++){
                kth = kth.next;
            }
            if(kth==null){
                break;
            }
            ListNode nextGroup = kth.next;
            ListNode curr = prevGroup.next;
            ListNode prev = nextGroup;
            while(curr!=nextGroup){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            ListNode temp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = temp;
        }
        return dummy.next;
    }
}
