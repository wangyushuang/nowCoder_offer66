/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
// 思路：递归
public class treeMirror
 {
    public void Mirror(TreeNode root) 
    {
        if(root==null)
            return;
        Mirror(root.left);
        Mirror(root.right);
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
    }
}