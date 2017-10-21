//思路：
	//1.只能包含+、-、.、数字、e、E
	//2.正负号只能出现在首位，或者紧跟在e或E后面
	//3.点只能出现一次，且前面不能是e和E
	//4.e的前面必须是数字
	//5.最后一位必须是数字
public class isNum {
    public boolean isNumeric(char[] str) 
    {
        boolean flag=false;//true表示之后不能有小数点
        for(int i=0;i<str.length;i++)
        {
            if(str[i]=='+' || str[i]=='-' || str[i]=='.'
              || str[i]=='E' || str[i]=='e' || (str[i]>='0' && str[i]<='9'))
            {
                //正负号不合法
                if((str[i]=='+' || str[i]=='-') && (!(i==0 || str[i-1]=='e' || str[i-1]=='E')))
                    return false;
                //小数点不合法
                if(str[i]=='.' && flag)
                    return false;//另外：小数点前一位不能是正负号
                if(str[i]=='.' || str[i]=='e' || str[i]=='E')
                    flag=true;//之后不能出现小数点
                //e、E不合法
                if((str[i]=='e' || str[i]=='E') && (i==0 || str[i-1]=='.'))
                    return false;
                //最后一位只能是数字
                if(i==str.length-1 && !(str[i]>='0' && str[i]<='9'))
                    return false;
            }
            else
                return false;
        }
        return true;
    }
}