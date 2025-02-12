package self.node;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

class NodeSet {
    public static void main(String[] args) {
        //1. 원하는 길이 만큼의 노드 생성
        int len = 3;
        ListNode head1 = new ListNode();
        ListNode node1 = head1;
        //head1이 초기화되어있어야 포인팅이 가능하므로 하나만큼 덜 반복하면 됨.
        for(int i=0; i<len-1; i++) {
            node1.next = new ListNode();
            node1 = node1.next;
        }
        //노드 포인터 초기화
        node1 = head1;

        //2. 다른 노드와 같은 길이 만큼의 노드 생성
        ListNode head2 = new ListNode();
        ListNode node2 = head2;
        //head2가 초기화되어있어야 노드 포인터 선언이 가능하므로 하나만큼 덜(next) 반복하면 됨.
        while(node1.next != null) {
            node2.next = new ListNode();
            node2 = node2.next;
            node1 = node1.next;
        }
        node2 = head2;
    }
}
