package newcode;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main3 {
    //    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        Stack<Integer> stack = new Stack<>();
//        while (listNode!=null){
//            stack.add(listNode.val);
//            listNode = listNode.next;
//        }
//        while (!stack.isEmpty()){
//            arrayList.add(stack.pop());
//        }
//        return arrayList;
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode==null)
            return arrayList;
        return solve(arrayList,listNode);
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> list,ListNode node){
        if (node.next!=null){
            list = solve(list,node.next);
        }
        System.out.println(list);
        list.add(node.val);
        return list;
    }





    public static void main(String[] args){
        ListNode head = new ListNode(0);
        //moveNode类似于尾结点
        ListNode moveNode = head;
        for (int i=1;i<10;i++){
            ListNode x = new ListNode(i);
            x.next = null;
            moveNode.next = x;
            moveNode = x;

        }
        System.out.println(printListFromTailToHead(head));
    }
}
class ListNode{
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }

}