package leetcode.linkedlist.ninetwo;

public class ReverseLinkedList2_92 {
}

class Solution_Mine {
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

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 예외 처리
        if (head == null) return null;
        // 임시 노드 선언
        ListNode root = new ListNode(0);
        //임시 노드 다음으로 노드 시작
        root.next = head;
        //임시 노드부터 시작해 변경 필요한 위치 앞으로 이동
        ListNode start = root;
        for (int i=0; i< left - 1; i++)
            start = start.next;

        //변경이 필요한 마지막 위치 선언
        ListNode end = start.next;
        // right - left만큼 위치 변경 진행
        for(int i=0; i< right - left; i++) {
            ListNode tmp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = tmp;
        }
        return root.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}