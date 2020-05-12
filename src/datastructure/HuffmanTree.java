package datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node1 root = createHuffmanTree(arr);
        //测试
        preOrder(root);
    }
    public static void preOrder(Node1 root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("是空树，不能遍历~~");
        }
    }

    public static Node1 createHuffmanTree(int[] arr){
        //为了操作方便
        //1.遍历arr数组
        //2.将arr的每个元素构成一个Node
        //3.将Node放入到ArrayList中
        List<Node1> nodes= new ArrayList<>();
        for (int value:arr){
            nodes.add(new Node1(value));
        }
        while (nodes.size()>1){
        //从小到大排序
                Collections.sort(nodes);
                System.out.println("nodes="+nodes);

                //取出权值最小的两棵二叉树
                //(1)最小的
                Node1 leftNode = nodes.get(0);
                //(2)次小的
                Node1 rightNode = nodes.get(1);
                //（3）构建新的二叉树
                Node1 parent = new Node1(leftNode.value+rightNode.value);
                parent.left = leftNode;
                parent.right = rightNode;
                //(4)从ArrayList中删除
                nodes.remove(leftNode);
                nodes.remove(rightNode);
                //(5)将parent加入
                nodes.add(parent);
        }
        //        Collections.sort(nodes);
        //        System.out.println("第一次处理后"+nodes);
                return nodes.get(0);
    }
}
//创建节点类,为了让Node对象持续排序Collections几何排序
//让Node实现Comparable接口
class Node1 implements Comparable<Node1>{
    int value;
    Node1 left;
    Node1 right;
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    public Node1(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public int compareTo(Node1 o){
        return this.value-o.value;
        //从小到大，反过来从大到小
    }
}
