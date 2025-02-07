package leetcode.linkedlist.twozerosix;

public class ReverseLinkedList_206 {
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, node = head;
        while(node != null) {
            ListNode next = node.next;
            node.next=prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}