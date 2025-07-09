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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        // Step 1: Find total length
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Step 2: Determine base size and extras
        int partSize = length / k;
        int extra = length % k;

        // Step 3: Split list
        ListNode current = head;
        for (int i = 0; i < k; i++) {
            result[i] = current;
            int currentPartSize = partSize + (i < extra ? 1 : 0);
            for (int j = 0; j < currentPartSize - 1; j++) {
                if (current != null) current = current.next;
            }
            if (current != null) {
                ListNode next = current.next;
                current.next = null;
                current = next;
            }
        }

        return result;
    }
}