package newcode;

public class Main38 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public int TreeDepth(TreeNode root) {
        if(root==null) return 0;
        return  Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;

    }
}
