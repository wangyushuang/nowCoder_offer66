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
public class treeDepth {
    public int TreeDepth(TreeNode root) 
    {
        if(root==null)
            return 0;
        int leftDep=TreeDepth(root.left);
        int rightDep=TreeDepth(root.right);
        return leftDep>rightDep?(1+leftDep):(1+rightDep);
    }
}