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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode ptr = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode l : lists){
            if(l!=null){
                queue.offer(l);
            }
        }
        while(!queue.isEmpty()){
            ListNode temp = queue.poll();
            ptr.next = temp;
            ptr = ptr.next;
            if(temp.next!=null){
                queue.offer(temp.next);
            }
        }
        return head.next;
    }
}
