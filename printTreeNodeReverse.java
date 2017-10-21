import java.util.ArrayList;

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
//思路：用两个栈实现翻转
import java.util.Stack;
public class printTreeNodeReverse {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) 
    {
        Stack<TreeNode> st1=new Stack<TreeNode>();
        Stack<TreeNode> st2=new Stack<TreeNode>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(pRoot==null)
            return result;
        st1.push(pRoot);
        TreeNode tmp=null;
        boolean flag=false;//false-打印
        while(!st1.empty() || !st2.empty())
        {
            while(!st1.empty())//将st1中结点弹出，并将所有结点的左右子树压入st2
            {
                tmp=st1.pop();
                if(tmp.left!=null) st2.push(tmp.left);
                if(tmp.right!=null) st2.push(tmp.right);
                list.add(tmp.val);
            }
            if(!list.isEmpty())
            {
                result.add((ArrayList<Integer>)list.clone());
                clear(list);
            }
            while(!st2.empty())//将st2中结点弹出，并将所有结点的左右子树压入st1
            {
                tmp=st2.pop();
                if(tmp.right!=null) st1.push(tmp.right);
                if(tmp.left!=null) st1.push(tmp.left);
                list.add(tmp.val);
            }
            if(!list.isEmpty())
            {
                result.add((ArrayList<Integer>)list.clone());
                clear(list);
            }
        }
        return result;
    }
    public void clear(ArrayList<Integer> list)//清空list
    {
        while(!list.isEmpty())
        {
            list.remove(0);
        }
    }

}