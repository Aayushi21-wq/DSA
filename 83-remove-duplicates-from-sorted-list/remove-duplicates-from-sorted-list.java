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
    // TC O(N) SC O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while(temp!=null && temp.next!=null ){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next; // Jump 2
            }
            else{
            temp = temp.next; // Jump 1
            }
        }
        return head;
    }
}