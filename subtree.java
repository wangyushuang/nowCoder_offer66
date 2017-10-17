/*
class TreeNode 
{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) 
    {
        this.val = val;
    }
}*/
// 思路：
//     1.如果root1的根节点等于root2的根节点，则判断root2是不是root1包含根节点的子结构，否则进入2
//     2.判断root1的左子树或右子树是否包含root2
//     3.递归
public class subtree 
{
    public boolean HasSubtree(TreeNode root1,TreeNode root2) 
    {
        if(root1==null || root2==null)
            return false;
        boolean hasSubTree=isSubTree(root1,root2);
        if(!hasSubTree)
            hasSubTree=HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
        return hasSubTree;
    }
    public boolean isSubTree(TreeNode root1,TreeNode root2)
    {
        if(root1==null && root2!=null)
            return false;
        if(root2==null)
            return true;
        boolean isST=false;
        if(root1.val==root2.val)
            isST=isSubTree(root1.left,root2.left) && isSubTree(root1.right,root2.right);
        return isST;
    }
}