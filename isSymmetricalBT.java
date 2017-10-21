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
//思路：
//	1.创建一个动态数组，左子树的结点添加到数组左边，右子树的结点添加到右边
//	2.创建两个指针，分别指向数组头部和尾部，判断指针指向的结点的值是否相等
//	3.若相等，将指针指向的结点移出，且将其左右结点按序添加到数组,运行2，否则返回false
import java.util.ArrayList;
public class isSymmetricalBT {
    boolean isSymmetrical(TreeNode pRoot)
    {
        ArrayList<TreeNode> list=new ArrayList<TreeNode>();
        int p=0;//指向数组头部
        int q;//指向数组尾部
        if(pRoot==null)
            return true;
        if(pRoot.left==null && pRoot.right==null)
            return true;
        if(pRoot.left==null ^ pRoot.right==null)
            return false;
        list.add(pRoot.left);
        list.add(pRoot.right);
        TreeNode tmp1=null,tmp2=null;
        while(!list.isEmpty())
        {
            q=list.size()-1;
            tmp2=list.remove(q);
            tmp1=list.remove(p);
            if(tmp1.val==tmp2.val)
            {
                if((tmp1.left==null ^ tmp2.right==null)
                  || (tmp1.right==null ^ tmp2.left==null))
                    return false;
                if(tmp1.right!=null) list.add(0,tmp1.right);
                if(tmp1.left!=null) list.add(0,tmp1.left);
                if(tmp2.left!=null) list.add(tmp2.left);
                if(tmp2.right!=null) list.add(tmp2.right);
            }
            else
                return false;
        }
        return true;
    }
}