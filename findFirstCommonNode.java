/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
//思路：要找第一个公共节点，应该从后往前看，如果某节点result的前一个节点的值不相同
//		则result为第一个公共节点。利用Stack后进先出的特性。
import java.util.Stack;
public class findFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) 
    {
        Stack<ListNode> stack1=new Stack<ListNode>();
        Stack<ListNode> stack2=new Stack<ListNode>();
        ListNode tmp1=pHead1;
        ListNode tmp2=pHead2;
        ListNode result=null;
        while(tmp1!=null)
        {
            stack1.push(tmp1);
            tmp1=tmp1.next;
        }
        while(tmp2!=null)
        {
            stack2.push(tmp2);
            tmp2=tmp2.next;
        }
        while(!stack1.empty() && !stack2.empty())
        {
            tmp1=stack1.pop();
            tmp2=stack2.pop();
            if(tmp1.val!=tmp2.val)
                break;
            else
                result=tmp1;
        }
        return result;
    }
}