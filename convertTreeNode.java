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
//     1.创建一个指针tmp，指向左子树最右边的元素(即左子树的最大值),
//         令tmp.right=pRootOfTree,pRootOfTree.left=tmp
//     2.令tmp指向右子树最左边的元素(即右子树的最小值)，
//         令tmp.left=pRootOfTree,pRootOfTree.right=tmp;
public class convertTreeNode {
    public TreeNode Convert(TreeNode pRootOfTree) 
    {
        if(pRootOfTree==null)
            return null;
        if(pRootOfTree.left==null && pRootOfTree.right==null)
            return pRootOfTree;
        TreeNode tmp=Convert(pRootOfTree.left);
        if(tmp!=null)
        {
            while(tmp.right!=null)//查找左子树最大值
                tmp=tmp.right;
            pRootOfTree.left=tmp;
            tmp.right=pRootOfTree;
        }
        
        tmp=Convert(pRootOfTree.right);//右子树最小值
        if(tmp!=null)
        {
            pRootOfTree.right=tmp;
            tmp.left=pRootOfTree;
        }
        //返回最小值,即最左边的值
        tmp=pRootOfTree;
         while(tmp.left!=null)
            tmp=tmp.left;
        return tmp;
    }
}