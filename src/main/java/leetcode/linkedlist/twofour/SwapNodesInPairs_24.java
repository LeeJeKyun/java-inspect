package leetcode.linkedlist.twofour;

public class SwapNodesInPairs_24 {
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode node = head;

        while( node != null && node.next != null) {
            int tmp;
            tmp = node.val;
            node.val = node.next.val;
            node.next.val = tmp;
            node = node.next.next;
        }

        return head;
    }
}
class Solution2 {
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0);

        ListNode root = node;
        node.next = head;
        while (node.next != null && node.next.next != null) {
            ListNode a = node.next;
            ListNode b = node.next.next;

            a.next = b.next;
            b.next = a;
            node.next = b;

            node = node.next.next;
        }

        return root.next;
    }
}
class Solution3 {
    public ListNode swapPairs(ListNode head) {
        if(head != null && head.next != null) {
            //다음 노드 선언
            ListNode p = head.next;
            //다음 다음 노드를 파라미터로 전달하고 스왑된 값을 리턴받음
            head.next = swapPairs(head.next.next);
            p.next = head;
            return p;
        }
        return head;
    }
}


// * Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}