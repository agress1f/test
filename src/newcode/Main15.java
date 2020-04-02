package newcode;

import java.util.List;
import java.util.Stack;

//public class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}
public class Main15 {
    public ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode frontNode = head;
        ListNode removeNode = head.next;
        while (removeNode!=null){
            ListNode tempNode=removeNode.next;
            removeNode.next = frontNode;
            frontNode = removeNode;
            removeNode = tempNode;
        }
        head.next = null;
        return removeNode;

//        ListNode node = head.next;
//        Stack<ListNode> sk = new Stack<>();
//        int sum=0;
//        while (node!=null){
//            sum++;
//            node = node.next;
//            sk.push(node);
//        }
//        ListNode newhead  = sk.pop();
//        return newhead;
    }
}
