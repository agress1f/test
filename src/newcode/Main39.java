package newcode;

public class Main39 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

        private boolean ans;
        public boolean IsBalanced_Solution(TreeNode root) {
            ans = true;
            if (root==null) return true;
            TreeDepth(root);
            return ans;

        }
        private int TreeDepth(TreeNode node){
            if (node==null){
                return 0;
            }
            if (ans){
                int leftDepth = TreeDepth(node.left);
                int rightDepth = TreeDepth(node.right);
                if (Math.abs(leftDepth-rightDepth)>1){
                    ans = false;
                }
                return Math.max(leftDepth,rightDepth)+1;
            }
            return 0;

        }

}
