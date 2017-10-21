/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
import java.util.ArrayList;
public class etryNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ArrayList<ListNode> list=new ArrayList<ListNode>();
        ListNode node=pHead;
        while(node!=null)
        {
            if(list.contains(node))
                return node;
            list.add(node);
            node=node.next;
        }
        return null;
    }
}