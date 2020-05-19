package datastructure;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i=0;i<arr.length;i++){
            binarySortTree.add(new Node2(arr[i]));
        }
        System.out.println("中序遍历二叉排序树");
        binarySortTree.infixOrder();
        //测试删除叶子节点
        binarySortTree.delNode(2);
        binarySortTree.delNode(5);
        binarySortTree.delNode(9);
       binarySortTree.delNode(12);
        binarySortTree.delNode(7);
        binarySortTree.delNode(3);
        binarySortTree.delNode(10);
        binarySortTree.delNode(1);
        System.out.println("删除节点后");
        binarySortTree.infixOrder();
    }
}
class BinarySortTree{
    private Node2 root;

    public Node2 getRoot() {
        return root;
    }

    //查找要删除的节点
    public Node2 search(int value){
        if (root==null){
            return null;
        }else {
            return root.search(value);
        }
    }
    //查找父节点
    public Node2 searchParent(int value){
        if (root==null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }
    //编写方法
    //1.返回以node为根节点的二叉排序树的最小结点的值
    //2.删除node为根节点的二叉排序树的最小节点
    /*
    * @param node传入的节点（二叉排序树的根节点）
    * @return 返回的以node为根节点的二叉排序树的最小节点的值
    *
    * */
    public int delRightTreeMin(Node2 node){
        Node2 target = node;
        while (target.left!=null){
            target = target.left;
        }
        //target指向最小节点
        //删除最小节点
        delNode(target.value);
        return target.value;
    }




    //删除节点
    public void delNode(int value){
        if (root==null){
            return;
        }else {
            Node2 targetNode = search(value);
            //如果没有找到要删除的节点
            if (targetNode==null){
                return;
            }
            //如果发现二叉排序树只有一个节点
            if (root.left==null&&root.right==null){
                root = null;
                return;
            }
            //去找到targetNode的父节点
            Node2 parent = searchParent(value);
            if (targetNode.left==null&&targetNode.right==null){
                //判断targetNode是父节点的左子节点，还是有子节点
                if (parent.left!=null&&parent.left.value==value){
                    parent.left = null;
                }else if (parent.right!=null&&parent.right.value==value){
                    parent.right = null;
                }
            }else if (targetNode.left!=null&&targetNode.right!=null){
                //删除有两科子树
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;

            }else {
                //删除的节点有只一颗子树
                //要删除的节点只有左子节点
                if (targetNode.left!=null){
                    if (parent!=null) {
                        //targetNode是Parent的左子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    }else {
                        root = targetNode.left;
                    }
                }else {
                    if (parent!=null){
                    if (parent.left.value==value){
                        parent.left = targetNode.right;
                    }else {
                        parent.right = targetNode.right;
                    }
                    }else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }
    public void add(Node2 node){
            if (root ==null){
                root = node;
            }else {
                root.add(node);
            }
    }

    public void infixOrder(){
        if (root!=null){
            root.infixOrder();
        }else {
            System.out.println("二叉排序树为空");
        }
    }

}


class Node2{
    int value;
    Node2 left;
    Node2 right;
    public Node2(int value){
        this.value = value;
    }

    //查找要删除的节点
    public Node2 search(int value){
        if (value == this.value){
            //招待就是该节点
            return this;
        }else if (value<this.value){
            //如果左子节点为空
            if (this.left==null){
                return null;
            }
            return this.left.search(value);
        }else {
            if (this.right==null){
                return null;
            }
            return this.right.search(value);
        }
    }

    public Node2 searchParent(int value){
        //子节点的值是要删除的值
        if ((this.left!=null && this.left.value==value)||(this.right!=null&&this.right.value==value)){
            return this;
        }else {
            //如果查找的值小于当前节点的值，并且当前节点的左子节点不为空
            if (value<this.value&&this.left!=null){
                return this.left.searchParent(value);
            }else if (value>=this.value&&this.right!=null){
                return this.right.searchParent(value);
            }else {
                return null;
            }
        }
    }

    @Override
    public String toString() {
        return "Node2{" +
                "value=" + value +
                '}';
    }

    public void add(Node2 node){
        if (node==null){
            return;
        }
        if (node.value<this.value){
            //如果当前节点左子节点为空
            if (this.left==null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {//添加的节点的值大于当前节点的值
            if (this.right==null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }

    }
    //中序遍历
    public void infixOrder(){
       if (this.left!=null){
           this.left.infixOrder();
       }
        System.out.println(this);
       if (this.right!=null){
           this.right.infixOrder();
       }
    }

}
