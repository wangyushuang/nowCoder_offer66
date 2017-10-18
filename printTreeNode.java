import java.util.ArrayList;
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
// 思路：
//     1.创建一个队列list，并将root放入list
//     2.将队首元素移出队列，其值放入result，并将该元素的左右子树（如果有的话）分别放入队尾
//     3.重复2直到list为空
public class printTreeNode {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) 
    {
        ArrayList<Integer> result=new ArrayList<Integer>();
        ArrayList<TreeNode> list=new ArrayList<TreeNode>();
        if(root==null)
            return result;
        list.add(root);
        TreeNode tmp;
        while(!list.isEmpty())
        {
            tmp=list.remove(0);
            if(tmp.left!=null)
                list.add(tmp.left);
            if(tmp.right!=null)
                list.add(tmp.right);
            result.add(tmp.val);
        }
        return result;
    }
}