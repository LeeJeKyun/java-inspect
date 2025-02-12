package leetcode.linkedlist.two;

import java.math.BigInteger;
import java.util.List;

public class AddTwoNumbers_2 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(), node = head1;
        for(int i=1; i<4; i++) {
            node.next=new ListNode();
            node = node.next;
        }
        head1.val = 9;
        head1.next.val = 9;
        head1.next.next.val = 9;
        head1.next.next.next.val = 9;
//        head1.next.next.next.next.val = 9;
//        head1.next.next.next.next.next.val = 9;
//        head1.next.next.next.next.next.next.val = 9;
//        head1.next.next.next.next.next.next.next.val = 9;
//        head1.next.next.next.next.next.next.next.next.val = 9;

        ListNode head2 = new ListNode(), node2 = head2;
        for(int i=1; i<2; i++) {
            node2.next = new ListNode();
            node2 = node2.next;
        }
        head2.val=9;
        head2.next.val=9;
//        head2.next.next.val=9;
//        head2.next.next.next.val=9;

        MySolution2 mySolution = new MySolution2();
        ListNode listNode = mySolution.addTwoNumbers(head1, head2);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //임시 노드 선언
        ListNode node = new ListNode();
        //임시 노드를 첫 번째 노드로 선언
        ListNode root = node;

        //자릿수의 합(sum), 자리올림수(carry), 나머지(remainder)를 저장할 변수 선언
        int sum, carry = 0, remainder;
        //모든 연결 리스트를 끝까지 순회하고, 자리올림수도 0이 될 때까지 진행
        while(l1 != null || l2 != null || carry != 0) {
            sum = 0;
            // 첫 번째 연결 리스트 합산 및 진행
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            // 두 번째 연결 리스트 합산 및 진행
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            //노드의 값으로 사용할 나머지 계산
            remainder = (sum + carry) % 10;
            // 10으로 나누었을 때 몫은 자릿수가 증가했다는 의미이므로 자리올림수로 사용
            carry = (sum + carry) / 10;
            // 나머지는 다음 노드의 값으로 지정
            node.next = new ListNode(remainder);
            // 계산할 노드를 다음으로 이동
            node = node.next;
        }

        return root.next;
    }
}

class MySolution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        ListNode n1 = l1, n2 = l2, ns = sum;
        //l1과 l2의 길이 조사
        int l1Len = 0;
        int l2Len = 0;
        while(n1 != null) {
            l1Len++;
            n1 = n1.next;
        }
        while(n2 != null) {
            l2Len++;
            n2 = n2.next;
        }

        //n1, n2 포인터 초기화
        n1 = l1;
        n2 = l2;

        //결과값의 길이 선정
        int sumLen = Math.max(l1Len, l2Len);
        //결과값의 길이만큼 Node 생성
        for(int i=1; i<sumLen; i++) {
            ns.next = new ListNode();
            ns = ns.next;
        }

        //결과값 포인터 초기화
        ns = sum;

        while(ns != null) {
            int val1 = n1 == null? 0 : n1.val;
            int val2 = n2 == null? 0 : n2.val;
            ns.val = val1 + val2;
            if(n1 !=null) n1 = n1.next;
            if(n2 !=null) n2 = n2.next;
            ns = ns.next;
        }

        //시작포인터 초기화
        ns = sum;

        while(ns != null) {
            if(ns.val >= 10) {
                ns.val %= 10;
                if(ns.next == null) {
                    ns.next = new ListNode();
                    ns.next.val = 1;
                } else {
                    ns.next.val += 1;
                }
            }
                ns = ns.next;
        }

        return sum;

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
}

class ListNode{
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}