class Solution {
    // TC O(N) SC O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step - 1 Count the total number of nodes
        int count = 0;
        ListNode temp = head;
        if(head== null){
            return null;
        }
        
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        // Step - Compute where i need to reach
        int reach = count - n;
        if(reach == 0){
            return head.next;
        }
        temp = head;
        for(int i = 1; i<=reach-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}