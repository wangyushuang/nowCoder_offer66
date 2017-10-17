import java.util.Stack;
public class stackWithMin {
    Stack<Integer> sta=new Stack<Integer>();
    Stack<Integer> sta1=new Stack<Integer>();
    public void push(int node) 
    {
        sta.push(node);
    }
    
    public void pop() 
    {
        sta.pop();
    }
    
    public int top() 
    {
        return sta.peek();
    }
    
    public int min() 
    {
        int result=top();
        sta1.push(sta.pop());
        while(!sta.empty())
        {
            if(top()<result)
                result=top();
            sta1.push(sta.pop());
        }
        while(!sta1.empty())
        {
            sta.push(sta1.pop());
        }
        return result;
    }
}