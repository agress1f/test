package newcode;

public class Main18 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public void Mirror(TreeNode root) {
        if (root!=null){
            if (root.right!=null){
                Mirror(root.right);
            }
            if (root.left!=null){
                Mirror(root.left);
            }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

        }
}
}
