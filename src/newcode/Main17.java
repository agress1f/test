package newcode;

public class Main17 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    private boolean judge(TreeNode node1,TreeNode node2){
        if (node1==null){
            return false;
        }
        if (node2==null){
            return true;
        }
        if (node1.val == node2.val){
            boolean flag1 = true;
            boolean flag2 = true;
            if (node1.left!=null||node2.left!=null){
                flag1 = judge(node1.left,node2.left);
            }
            if (node1.right!=null||node2.right!=null){
                flag2 = judge(node1.right,node2.right);
            }
            return flag1&&flag2;
        }else {
            return false;
        }
    }
    //二叉树先序遍历
    public  boolean dfs(TreeNode node,TreeNode root2){
        boolean flag = false;
        if (node.val==root2.val){
            flag = judge(node,root2);
        }
        if (flag){
            return true;
        }
        boolean flag1 = false;
        boolean flag2 = false;
        if (node.left!=null){
            flag1 = dfs(node.left,root2);
        }
        if ((!flag1)&&node.right!=null){
            flag2 = dfs(node.right,root2);
        }

        return flag1||flag2;
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1==null||root2==null){
            return false;
        }
        return dfs(root1,root2);
    }
}
