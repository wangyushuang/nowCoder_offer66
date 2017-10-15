// 思路：
//     1.根的值为前序遍历的第一个元素
//     2.在中序遍历中，根左边的元素为左子树的元素，根的右边为右子树元素
//     3.将前序遍历中的元素分为左右子树
//     4.根据左右子树的前序遍历结果和中序遍历结果构造根的左右子树（递归）
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;
public class reConBT {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) 
    {
        if(pre.length==0)
            return null;
        TreeNode root=new TreeNode(pre[0]);
        boolean flag=false;
        ArrayList<Integer> lInList=new ArrayList();//左子树的中序遍历
        ArrayList<Integer> rInList=new ArrayList();//右子树的中序遍历
        for(int i=0;i<in.length;i++)
        {
            if(in[i]==pre[0])
            {
                flag=true;
                continue;
            }
            if(!flag)
                lInList.add(in[i]);
            else
                rInList.add(in[i]);
        }
        int[] lIn=new int[lInList.size()];//左子树的中序遍历
        int[] rIn=new int[rInList.size()];//右子树的中序遍历
        int[] lPre=new int[lInList.size()];//左子树的前序遍历
        int[] rPre=new int[rInList.size()];//右子树的前序遍历
        for(int i=0;i<lInList.size();i++)
        {
            lIn[i]=lInList.get(i).intValue();
            lPre[i]=pre[i+1];
        }
        for(int i=0;i<rInList.size();i++)
        {
            rIn[i]=rInList.get(i).intValue();
            rPre[i]=pre[i+1+lInList.size()];
        }
        root.left=reConstructBinaryTree(lPre,lIn);
        root.right=reConstructBinaryTree(rPre,rIn);
        return root;
    }
}