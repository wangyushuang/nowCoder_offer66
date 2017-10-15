// 思路：
// 1.如果模式中第j+1个字符为’*’，则判断第j个字符是否等于’.’或者字符串的第i个字符。
    // 如果是，则递归判断模式第j+2个字符是否与字符串的第i个字符是否匹配，或者模式的第j个字符是否与字符串的第i+1个字符匹配；
    // 如果否，则递归判断模式第j+2个字符是否与字符串的第i个字符匹配。
// 2.如果模式中的第j个字符为’.’或者等于字符串的第i个字符，则递归判断模式的第j+1个字符与字符串的第i+1个字符。
// 3.如果上面两种情况都不满足，则返回false。

public class regExpr 
{
    public boolean match(char[] str, char[] pattern)
    {
        if(str.length==0 && pattern.length==0)
            return true;
        return matchCore(str,pattern,0,0);
    }
    public boolean matchCore(char[] str, char[] pattern, int i, int j)
    {
        if(j==pattern.length && i==str.length)
            return true;
        if(j==pattern.length && i!=str.length)//当pattern的元素遍历完，则结束递归
            return false;
        if(j<pattern.length-1 && pattern[j+1]=='*')
        {
            if(i<str.length && (pattern[j]=='.' || pattern[j]==str[i]))
                return matchCore(str,pattern,i,j+2) || matchCore(str,pattern,i+1,j);
            else
                return matchCore(str,pattern,i,j+2);
        }
        if(i<str.length && (pattern[j]=='.' || pattern[j]==str[i]))
            return matchCore(str,pattern,i+1,j+1);
        return false;
    }
}