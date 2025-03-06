package leetcode.linkedlist.threetwoeight;

public class OddEvenLinkedList_328 {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode node = head;
        ListNode odd = head;
        ListNode evenhead = head.next;
        ListNode even = head.next;
        while(node.next != null && node.next.next != null) {
            node = node.next.next;
            odd.next = node;
            even.next = node.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}