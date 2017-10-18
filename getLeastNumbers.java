//思路：
    // 1.初始化：取input的前k个数放入result中，并排序
    // 2.遍历input剩余的数，若该数小于result中的数，则插入到result中
import java.util.ArrayList;
public class getLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) 
    {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(k>input.length || k<=0)
            return result;
        for(int i=0;i<k;i++)//初始化数组
            result.add(input[i]);
        //对数组排序(冒泡)
        int tmp;
        if(k>1)
            for(int i=0;i<k-2;i++)
                for(int j=0;j<k-1-i;j++)
                {
                    if(result.get(j)>result.get(j+1))
                    {
                        tmp=result.get(j);
                        result.set(j,result.get(j+1));
                        result.set(j+1,tmp);
                    }
                }
        //遍历input剩下的数，若小于result中的数，则插入result中
        for(int i=k;i<input.length;i++)
        {
            for(int j=0;j<k;j++)
            {
                if(input[i]<result.get(j))
                {
                    result.add(j,input[i]);//插入
                    result.remove(k);//移出
                    break;
                }
            }
        }
        return result;
    }
}