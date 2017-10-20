public class leftRotateString {
    public String LeftRotateString(String str,int n) 
    {
        char[] ch=str.toCharArray();
        int len=ch.length;
        char[] result=new char[len];
        if(len==0) return str;
        if(n>=len) LeftRotateString(str,n%len);
        for(int i=0;i<ch.length-n;i++)//左移
        {
            result[i]=ch[n+i];
        }
        for(int i=len-n;i<len;i++)//前面k位移到末尾
        {
            result[i]=ch[i-len+n];
        }
        return String.valueOf(result);
    }
}
