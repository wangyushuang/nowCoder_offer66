/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
//思路：先按值的大小从小到大排列树的所有结点
import java.util.ArrayList;
public class kthNode {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null)
            return null;
        ArrayList<TreeNode> list=sort(pRoot);
        if(k<=0 || k>list.size())
            return null;
        return list.get(k-1);
    }
    //递归排序
    ArrayList<TreeNode> sort(TreeNode pRoot)
    {
        ArrayList<TreeNode> list=new ArrayList<TreeNode>();
        if(pRoot.left==null && pRoot.right==null)
        {
            list.add(pRoot);
            return list;
        }
        if(pRoot.left!=null)//左子树结点放入队列
        {
            list=sort(pRoot.left);
        }
        list.add(pRoot);//根结点放入队列
        ArrayList<TreeNode> tmp=null;
        if(pRoot.right!=null)//右子树结点放入队列
        {
            tmp=sort(pRoot.right);
            for(int i=0;i<tmp.size();i++)
                list.add(tmp.get(i));
        }
        return list;
    }


}