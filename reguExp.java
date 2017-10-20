//思路：
	//1.如果下一个字符(如果存在)是*，并且前一个字符是.或者与str中的当前字符相同
	//	则有两种情况：*与str当前字符匹配0次或大于0次
	//	如果匹配0次，则指针q向后移两位
	//	如果不止0次，则指针p向后移一位
	//2.如果pattern当前字符为.或者与str中的当前字符相同，p和q都向后移一位
	//3.上述两种情况都不满足，则返回false
//注意：当q指针到达pattern末尾时，停止递归
//		q未到达末尾时，p可能已经到达str的末尾
public class reguExp {
    public boolean match(char[] str, char[] pattern)
    {
        return matchCore(str,pattern,0,0);
    }
    public boolean matchCore(char[] str, char[] pattern, int p, int q)
    {
        //p-指向str的指针 q-指向pattern的指针
        //pattern遍历完即返回
        //考虑str已经遍历完，而pattern未遍历完的情况 
        if(p==str.length && q==pattern.length)
            return true;
        if(p!=str.length && q==pattern.length)
            return false;
        while(q<pattern.length)
        {
            if(q<pattern.length-1 && pattern[q+1]=='*')
            {
                if(p<str.length && (pattern[q]=='.' || pattern[q]==str[p]))
                    return matchCore(str,pattern,p+1,q) || matchCore(str,pattern,p,q+2);
                else
                    return matchCore(str,pattern,p,q+2);
            }
            if(p<str.length && (pattern[q]=='.' || pattern[q]==str[p]))
                return matchCore(str,pattern,p+1,q+1);
            return false;
        }
        return false;
    }
}