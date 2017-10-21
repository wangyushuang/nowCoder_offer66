/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
//思路： 保留与前后结点值都不相同的结点
public class delDuplication {
    public ListNode deleteDuplication(ListNode pHead)
    {
        //pFront-前一个结点 pFront.next-当前结点 pFront.next.next-后一个结点
        ListNode pFront=pHead;
        ListNode result=null;
        ListNode tmp=null;
        if(pHead==null || pHead.next==null)
            return pHead;
        if(pHead.val!=pHead.next.val)//如果第一个结点不重复，则将其作为result的第一个结点
        {
            result=new ListNode(pHead.val);
            tmp=result;
        }
        while(pFront.next!=null)//当前结点非空
        {
            if(pFront.next.next!=null)//当前结点之后还有结点
            {
                if(pFront.val!=pFront.next.val && pFront.next.val!=pFront.next.next.val)
                {
                    if(result==null)
                    {
                        result=new ListNode(pFront.next.val);
                        tmp=result;
                    }
                    else
                    {
                        tmp.next=new ListNode(pFront.next.val);
                        tmp=tmp.next;
                    }
                }
            }
            else//当前结点是最后一个结点
            {
                if(pFront.val!=pFront.next.val)
                {
                    if(result==null)
                        result=new ListNode(pFront.next.val);
                    else
                        tmp.next=new ListNode(pFront.next.val);
                }
            }
            pFront=pFront.next;
        }
        return result;
    }
}