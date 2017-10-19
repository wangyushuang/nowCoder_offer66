import java.util.ArrayList;
//思路：
//	1.创建一个ArrayList,存储numbers转换成String的结果
//	2.对ArrayList里的元素进行排序
//	3.将ArrayList的元素转化成String输出

public class printMinNumber {
    public String PrintMinNumber(int [] numbers) 
    {
        ArrayList<String> strArr=new ArrayList<String>();
        for(int i=0;i<numbers.length;i++)
        {
            strArr.add(String.valueOf(numbers[i]));
        }
        //冒泡法排序
        String tmp,tmp1,tmp2;
        for(int i=0;i<numbers.length-1;i++)
            for(int j=0;j<numbers.length-1-i;j++)
            {
                tmp1=strArr.get(j)+strArr.get(j+1);
                tmp2=strArr.get(j+1)+strArr.get(j);
                if(tmp1.compareTo(tmp2)>0)
                {
                    tmp=strArr.get(j);
                    strArr.set(j,strArr.get(j+1));
                    strArr.set(j+1,tmp);
                }
            }
        StringBuffer str=new StringBuffer();
        for(int i=0;i<numbers.length;i++)
            str.append(strArr.get(i));
        return str.toString();
    }
}