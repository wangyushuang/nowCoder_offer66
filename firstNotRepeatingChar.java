//思路：
//	1.如果str是空字符串或者str不存在只出现一次的字符，返回-1
//	2.遍历str中的每一个字符，如果存在相同字符，则把标志位置true
//	3.如果不存在相同字符，则说明该字符只出现一次
public class firstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) 
    {
        char[] ch=str.toCharArray();
        if(ch.length==0)
            return -1;
        boolean flag=false;
        for(int i=0;i<ch.length;i++)
        {
            flag=false;
            for(int j=0;j<ch.length;j++)
            {
                if(i!=j && ch[i]==ch[j])
                {
                    flag=true;
                    break;
                }
            }
            if(!flag)
                return i;
        }
        return -1;
    }
}