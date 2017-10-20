//思路：
//	1.创建一个字符串缓存变量strBuff
//	2.遍历str的每一个字符，如果该字符是空格，则将strBuff
//		压入堆栈，并将strBuff清空；如果该字符不是空格，则将字符
//		放入strBuff。
//	3.将堆栈中的字符串取出来，连接成新的字符串输出
import java.util.Stack;
public class reverseSentence {
    public String ReverseSentence(String str) 
    {
        StringBuffer strBuff=new StringBuffer();
        Stack<String> stack=new Stack<String>();
        int p=0;
        while(p<str.length())
        {
            if(str.charAt(p)==' ')
            {
                stack.push(strBuff.toString());
                while(strBuff.length()!=0)//清空strBuff
                    strBuff.deleteCharAt(0);
            }
            else
            {
                strBuff.append(str.charAt(p));
            }
            p++;
        }
        String result=strBuff.toString();
        while(!stack.empty())
        {
            result+=" ";
            result+=stack.pop();
        }
        return result;
    }
}
