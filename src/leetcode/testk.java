package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: GZH
 * Date: 2020/6/1
 * Time: 12:11
 * Description: No Description
 */
public class testk {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static class MyLinkedList {

        public ListNode head;
        public ListNode current;

        public void add(int data) {

            //如果头结点为空,为头结点
            if (head == null) {
                head = new ListNode(data);
                current = head;
            } else {
                current.next = new ListNode(data);
                current = current.next;
            }
        }

        //打印链表
        public void print(ListNode node) {
            if (node == null) {
                return;
            }

            current = node;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
        }

        //初始化链表,并且返回表头
        public ListNode init() {
            for (int i = 0; i < 10; i++) {
                this.add(i);
            }
            return head;
        }

        //求链表长度
        public int get_length(ListNode head) {
            if (head == null) {
                return -1;
            }

            int length = 0;
            current = head;
            while (current != null) {
                length++;
                current = current.next;
            }

            return length;
        }

        public static ListNode FindKthToTail(ListNode head,int k){
            ArrayList<ListNode> list = new ArrayList<>();
            while (head!=null){
                list.add(head);
                head = head.next;
            }
            int len  = list.size();
            ListNode need = list.get(len-k);
            return need;
        }

        public static void main(String[] args) {
            MyLinkedList list = new MyLinkedList();
            ListNode head = list.init();
            list.print(head);
            System.out.println();
            ListNode node1 = FindKthToTail(head,1);
            System.out.println("输出倒数第1个");
            System.out.println(node1.val);

        }
    }
}
