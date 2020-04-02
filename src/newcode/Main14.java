package newcode;

import java.util.Stack;

public class Main14 {
    public static class Node {
        int val;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }
    private static Node ans;
    private  static int sum;  //用来记录当前节点是倒数第几个
    private static void dfs(Node node,int k){
        if (node.next!=null){
            dfs(node.next,k);//递归到下一节点
        }
        sum++;
        if (sum==k){
            ans=node;
        }
    }
    public static Node FindKthToTail(Node head,int k) {
        //用栈的方法
//            if(head==null || k<=0)
//                return null;
//            int numbOfList=1;
//            Stack<Node> st = new Stack<Node>();
//            st.push(head);
//            Node node=head.next;
//            while(node!=null){
//                numbOfList++;
//                st.push(node);
//                node=node.next;
//            }
//            if(k>numbOfList)
//                return null;
//            else{
//                for(int i=1;i<=k;i++){
//                    node=st.pop();
//                }
//                return node;
//            }

        //递归方法
         ans = null;
         sum =0;
        if (head==null){
            return null;
        }
        dfs(head,k);
        return ans;

        //距离为k的移动节点
//        Node removeNode = head;
//        while (k!=0){
//            if (removeNode==null){
//                return null;
//            }
//            removeNode = removeNode.next;
//            k--;
//        }
//        while (removeNode!=null){
//            removeNode = removeNode.next;
//            head = head.next;
//        }
//        return head;


        }
    public static class MyLinkedList {

        public Node head;
        public Node current;

        public void add(int data) {

            //如果头结点为空,为头结点
            if(head == null) {
                head = new Node(data);
                current = head;
            } else {
                current.next = new Node(data);
                current = current.next;
            }
        }

        //打印链表
        public void print(Node node) {
            if(node == null) {
                return;
            }

            current = node;
            while(current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
        }

        //初始化链表,并且返回表头
        public Node init() {
            for(int i=0; i<10; i++) {
                this.add(i);
            }
            return head;
        }

        //求链表长度
        public int get_length(Node head) {
            if (head == null) {
                return -1;
            }

            int length = 0;
            current = head;
            while(current != null) {
                length++;
                current = current.next;
            }

            return length;
        }

    }

        public static void main(String[] args){
            MyLinkedList list = new MyLinkedList();
            Node head = list.init();
            list.print(head);
//            System.out.println();
            Node node1 = FindKthToTail(head,2);
            System.out.println(node1.val);

        }
}
