package leetcode.linkedlist.two;

import java.math.BigInteger;

public class AddTwoNumbers_2 {
}

class MySolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = reverseList(l1);
        ListNode head2 = reverseList(l2);

        ListNode node1 = head1;
        ListNode node2 = head2;
        String l1Str = "";
        String l2Str = "";
        while(node1 != null) {
            l1Str += node1.val;
            node1 = node1.next;
        }

        while(node2 != null) {
            l2Str += node2.val;
            node2 = node2.next;
        }

        BigInteger l1Int = new BigInteger(l1Str);
        BigInteger l2Int = new BigInteger(l2Str);

        BigInteger l1l2Int = l1Int.add(l2Int);

        char[] resultArray = l1l2Int.toString().toCharArray();
        ListNode head = null, node = null;
        for(int i=0; i<resultArray.length; i++) {
            //head포인터가 null이면 최초생성 및 node도 head포인터 바라보기
            if (head == null) {
                head = new ListNode();
                node = head;
            } else {
                //아닌경우 노드의 다음 노드 선택 및 노드 생성
                node.next = new ListNode();
                node = node.next;
            }
            node.val = Integer.parseInt(String.valueOf(resultArray[i]));
        }
        ListNode result = reverseList(head);

        return result;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, node = head;
        while(node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(), node = head1;
        for(int i=0; i<2; i++) {
            node.next=new ListNode();
            node = node.next;
        }
        head1.val=2;
        head1.next.val=4;
        head1.next.next.val=3;

        ListNode head2 = new ListNode(), node2 = head2;
        for(int i=0; i<2; i++) {
            node2.next = new ListNode();
            node2 = node2.next;
        }
        head2.val=5;
        head2.next.val=6;
        head2.next.next.val=2;

        MySolution mySolution = new MySolution();
        ListNode listNode = mySolution.addTwoNumbers(head1, head2);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}