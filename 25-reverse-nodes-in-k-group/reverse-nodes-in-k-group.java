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
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode curr = head;

        while (true) {
            ListNode temp = curr;
            // Check if there are at least k nodes left to reverse
            int count = 0;
            while (temp != null && count < k) {
                temp = temp.next;
                count++;
            }
            if (count < k) break;

            // Reverse k nodes
            ListNode prev = null;
            ListNode tail = curr;
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect previous part with reversed group
            prevGroupEnd.next = prev;
            tail.next = curr;
            prevGroupEnd = tail;
        }

        return dummy.next;
    }
}