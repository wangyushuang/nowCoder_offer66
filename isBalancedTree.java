//平衡二叉树：它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
public class isBalancedTree {
    public boolean IsBalanced_Solution(TreeNode root) 
    {
        if(root==null)
            return true;
        boolean isBalanced=IsBalanced_Solution(root.left) && 
            IsBalanced_Solution(root.right);//左右子树都是平衡二叉树
        if(isBalanced)
        {
            int lHight=hightOfTree(root.left);
            int rHight=hightOfTree(root.right);
            if((lHight>=rHight && lHight-rHight<=1) ||(lHight<rHight && rHight-lHight<=1))
                return true;
        }
        return false;
    }
    public int hightOfTree(TreeNode root)//树的高度
    {
        if(root==null)
            return 0;
        int lHight=hightOfTree(root.left);
        int rHight=hightOfTree(root.right);
        return lHight>rHight?(1+lHight):(1+rHight);
    }
}