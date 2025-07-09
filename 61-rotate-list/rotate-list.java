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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find the length and tail
        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // Step 2: Make it a circular list
        curr.next = head;

        // Step 3: Find the new head and tail
        k = k % length;
        int stepsToNewHead = length - k;

        ListNode newTail = curr;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        // Step 4: Break the loop
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}