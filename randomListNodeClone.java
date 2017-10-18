/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class randomListNodeClone {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)
            return null;
        RandomListNode result=new RandomListNode(pHead.label);
        RandomListNode tmp1=result;
        RandomListNode tmp2=pHead;
        while(tmp2!=null)
        {
            if(tmp2.next!=null)
            	tmp1.next=new RandomListNode(tmp2.next.label);
            if(tmp2.random!=null)
            	tmp1.random=new RandomListNode(tmp2.random.label);
            tmp1=tmp1.next;
            tmp2=tmp2.next;
        }
        return result;
    }
}