public class strToInt {
    public int StrToInt(String str) 
    {
        int result=0;
        int tmp;
        for(int i=0;i<str.length();i++)
        {
            if(i==0 && (str.charAt(i)=='+' || str.charAt(i)=='-'))
                continue;
            tmp=str.charAt(i)-48;
            if(tmp<0 || tmp>9)//不是0-9
                return 0;
            result=result*10+tmp;
        }
        if(str.length()>0 && str.charAt(0)=='-')
            result=-result;
        return result;
    }
}