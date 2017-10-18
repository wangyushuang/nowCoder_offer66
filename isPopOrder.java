// 思路：
//     1.创建一个栈stack
//     2.如果出栈元素与栈顶元素相等，则弹出栈顶元素
//     3.如果不相等，则将新的元素压入栈，直到所有元素都入栈完毕。
//     4.所有元素都已入栈却还没找到要出栈的元素，返回false。
import java.util.ArrayList;
import java.util.Stack;
public class isPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) 
    {
        if(pushA.length==0 || popA.length==0 || pushA.length!=popA.length)
        {
            return false;
        }
        Stack stack=new Stack();
        int p=0;//popA 的Index
        int q=0;//pushA 的Index
        while(p<popA.length)
        {
            while(stack.empty() || (stack.peek()!=popA[p] && q<pushA.length))
            {
                stack.push(pushA[q++]);
            }
            if(stack.peek()==popA[p++])
            {
                stack.pop();
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}