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
        if(lists.length==0){
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode l:lists){
            if(l!=null){
                queue.offer(l);
            }
        }
        while(!queue.isEmpty()){
            ListNode temp = queue.poll();
            curr.next = temp;
            curr = curr.next;
            if(temp.next!=null){
                queue.offer(temp.next);
            }
        }
        return dummy.next;
    }
}
