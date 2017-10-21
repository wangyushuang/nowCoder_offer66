/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class getNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode tmp=null;
        if(pNode.right!=null)//右结点非空，则返回右子树的最左结点
        {
            tmp=pNode.right;
            while(tmp.left!=null)
                tmp=tmp.left;
            return tmp;
        }
        else//右结点为空，若当前结点是父结点的左结点，返回父结点
            //否则判断：父结点是否为祖父结点的左节点，是，则返回组父结点，否则继续往上走
        {
            tmp=pNode;
            while(tmp.next!=null)
            {
                if(tmp.next.left==tmp)
                    return tmp.next;
                else
                    tmp=tmp.next;
            }
            return null;
        }
    }
}