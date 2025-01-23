package leetcode.linkedlist.twothreefour;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class PalindromeLinkedList_234 {

}

class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while(node != null) {
            stack.add(node.val);
            node = node.next;
        }

        while(head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
class Solution_02 {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            deque.add(node.val);
            node = node.next;
        }

        while(!deque.isEmpty() && deque.size() > 1) {
            if(deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }
        return true;
    }
}
class Solution_03 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode rev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = rev;
            rev = slow;
            slow = next;
        }

        while (rev != null) {
            if (rev.val != head.val)
                return false;
            rev = rev.next;
            head = head.next;
        }
        return true;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}