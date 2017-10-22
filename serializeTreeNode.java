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
import java.util.Stack;
public class serializeTreeNode {
    String Serialize(TreeNode root) 
    {
        StringBuffer str=new StringBuffer();
        if(root==null)
            str.append("#!");
        else
        {
            str.append(root.val);
            str.append('!');
            str.append(Serialize(root.left));
            str.append(Serialize(root.right));
        }
        return str.toString();
    }
    TreeNode Deserialize(String str) 
    {
        //找出根的值
        int val=0;
        int pos=0;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        boolean flag=false;//false-左子树 true-右子树
        if(str.charAt(0)=='#')
            return null;
        while(str.charAt(pos)!='!')
        {
            val=val*10+str.charAt(pos)-'0';
            pos++;
        }
        pos++;
        TreeNode root=new TreeNode(val);
        TreeNode tmp=root;
        val=0;//清零
        stack.push(tmp);
        stack.push(tmp);
        while(pos<str.length())
        {
            if(str.charAt(pos)=='#')
            {
                pos+=2;
                val=0;
                tmp=stack.pop();
                flag=true;
                continue;
            }
            if(str.charAt(pos)=='!')
            {
                if(!flag)
                {
                    tmp.left=new TreeNode(val);
                    tmp=tmp.left;
                    stack.push(tmp);
                }
                else
                {
                    tmp.right=new TreeNode(val);
                    tmp=tmp.right;
                    stack.push(tmp);
                    flag=false;
                }
                val=0;
            }
            else
            {
                val=val*10+(int)str.charAt(pos)-'0';
            }
            pos++;	
        } 
        return root;
    }
}
















