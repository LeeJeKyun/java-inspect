package leetcode.linkedlist.ninetwo;

public class ReverseLinkedList2_92 {
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = head;
        for(int i=0; i<left-1; i++) {
            node = node.next;
        }
        ListNode prev = null;
        for(int i=0; i<right - left + 1; i++) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        ListNode before = head;
        if(left == 1) {
            before.next = node;
            return prev;
        }
        for(int i=0; i<left-2; i++) {
            before = before.next;
        }
        before.next = prev;
        for(int i=0; i<right - left; i++) {
            prev = prev.next;
        }
        prev.next = node;

        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}