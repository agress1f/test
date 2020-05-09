package datastructure;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1,"松江");
        HeroNode node2 = new HeroNode(2,"无用");
        HeroNode node3 = new HeroNode(3,"林冲");
        HeroNode node4 = new HeroNode(4,"贾宝玉");
        HeroNode node5 = new HeroNode(5,"关于");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        //测试
//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//        //测试
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//        //前序遍历方式
//        System.out.println("前序遍历方式~~~~~");
//        HeroNode resNode = binaryTree.preOrderSearch(5);
//        if (resNode!= null){
//            System.out.printf("找到了，信息为no=%d的name=%s",resNode.getNo(),resNode.getName());
//        }else {
//            System.out.printf("没有找到no=%d的英雄",5);
//        }
//        //中序遍历方式
//        System.out.println("中序遍历方式~~~~~");
//        HeroNode resNode1 = binaryTree.infixOrderSearch(5);
//        if (resNode1!= null){
//            System.out.printf("找到了，信息为no=%d的name=%s",resNode1.getNo(),resNode1.getName());
//        }else {
//            System.out.printf("没有找到no=%d的英雄",5);
//        }
        //后序遍历方式
//        System.out.println("后序遍历方式~~~~~");
////        HeroNode resNode1 = binaryTree.postOrderSearch(5);
////        if (resNode1!= null){
////            System.out.printf("找到了，信息为no=%d的name=%s",resNode1.getNo(),resNode1.getName());
////        }else {
////            System.out.printf("没有找到no=%d的英雄",5);
////        }
        //测试一把删除节点
        System.out.println("删除前，前序遍历：");
        binaryTree.preOrder();
        binaryTree.delNode(5);
        System.out.println("删除后，前序遍历：");
        binaryTree.preOrder();

    }
}
//定义二叉树
class BinaryTree{
    private HeroNode root;
    public void setRoot(HeroNode root){
        this.root = root;
    }

    //删除节点
    public void delNode(int no){
        if (root!=null){
            //如果只有一个root节点，这里理解判断root是不是删除节点
            if (root.getNo()==no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("空树，不能删除~");
        }
    }

    //前序
    public void preOrder(){
        if (this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序
    public void infixOrder(){
        if (this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序
    public void postOrder(){
        if (this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public HeroNode preOrderSearch(int no){
        if (root!=null){
             return root.preOrderSearch(no);
        }else {
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no){
        if (root!=null){
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }

    public HeroNode postOrderSearch(int no){
        if (root!=null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }
}


class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    public HeroNode(int no,String name){
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }



    public void delNode(int no){
        if (this.left!=null&&this.left.no==no){
            this.left=null;
            return;
        }
        if (this.right!=null&&this.right.no==no){
            this.right=null;
            return;
        }
        if (this.left!=null){
            this.left.delNode(no);
        }
        if (this.right!=null){
            this.right.delNode(no);
        }
    }


    //编写前序遍历
    public void preOrder(){

        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    //编写中序遍历
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }
    //编写后序遍历
    public void postOrder(){
        if (this.left!=null){
            this.left.postOrder();
        }
        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
/*
*no查找no
* 没有就返回null
*
*/
    public HeroNode preOrderSearch(int no){
        System.out.println("进入前序遍历");
        //比较当前节点是不是
        if (this.no==no){
            return this;
        }
        //判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        //如果左递归前序查找，找到节点，则返回
        HeroNode resNode = null;
        if (this.left!=null){
            resNode = this.left.preOrderSearch(no);
        }
        //左子树找到
        if (resNode!=null){
            return resNode;
        }
        if (this.right!=null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no){
        //判断当前节点的左子节点是否为空，如果不为空，则递归中序查找
        HeroNode resNode = null;
        if (this.left!=null){
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        System.out.println("进入中序查找");
        if (this.no==no){
            return this;
        }
        //否则继续进行右递归的中序查找
        if (this.right!=null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left!=null){
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.right!=null){
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        //如果左右子树都没有找到，就比较当前节点是不是
        System.out.println("进入后序查找");
        if (this.no==no){
            return this;
        }
        return resNode;
    }

}
