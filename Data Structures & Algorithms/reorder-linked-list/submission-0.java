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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        Stack<ListNode> stack = new Stack<>();
        while(fast.next!=null){
            fast = fast.next;
            if(fast.next!=null){
                fast=fast.next;
                slow = slow.next;
            }
        }
        ListNode start = slow.next;
        slow.next = null;
        while(start!=null){
            stack.push(start);
            start = start.next;
        }
        ListNode temp = head;
        while(!stack.isEmpty()){
            ListNode stor = temp.next;
            temp.next = stack.pop();
            temp = temp.next;
            temp.next = stor;
            temp = temp.next;
        }
    }
}
