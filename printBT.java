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
//思路：两个动态数组交替存放树的每一层
public class printBT {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) 
    {
        ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        ArrayList<TreeNode> que1=new ArrayList<TreeNode>();
        ArrayList<TreeNode> que2=new ArrayList<TreeNode>();
        if(pRoot==null)
            return result;
        que1.add(pRoot);
        TreeNode tmp=null;
        while(!que1.isEmpty() || !que2.isEmpty())
        {
            while(!que1.isEmpty())
            {
                tmp=que1.remove(0);
                if(tmp.left!=null) que2.add(tmp.left);
                if(tmp.right!=null) que2.add(tmp.right);
                list.add(tmp.val);
            }
            if(!list.isEmpty())
            {
                result.add((ArrayList<Integer>)list.clone());
                clear(list);
            }
            while(!que2.isEmpty())
            {
                tmp=que2.remove(0);
                if(tmp.left!=null) que1.add(tmp.left);
                if(tmp.right!=null) que1.add(tmp.right);
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
    void clear(ArrayList<Integer> list)
    {
        while(!list.isEmpty())
            list.remove(0);
    }
    
}