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

//        ListNode frontNode = head;
//        ListNode removeNode = head.next;
//        while (removeNode!=null){
//            ListNode tempNode=removeNode.next;
//            removeNode.next = frontNode;
//            frontNode = removeNode;
//            removeNode = tempNode;
//        }
//        head.next = null;
//        return removeNode;
        if (head == null){
            return null;
        }

        Stack<ListNode> sk = new Stack<>();

        while (head!=null){
            head = head.next;
            sk.push(head);
        }
        ListNode newnode  = sk.pop();
        ListNode newhead = newnode;
        newnode.next = null;
        while (!sk.isEmpty()){
            ListNode x = sk.pop();
            x.next = null;
            newnode.next = x;
            newnode = x;
        }
        return newhead;
    }
}
