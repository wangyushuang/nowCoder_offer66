//思路：
//	1.起始数必然小于sum/2，所以假设起始数为1，2，....，sum/2
//	2.序列的和小于sum时，继续累加，当序列的和等于sum时，将序列放入result中
//		当序列的和大于sum时，停止累加，换下一个起始数
import java.util.ArrayList;
public class findContinuousSequence {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) 
    {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        int tmp;
        int j;
        for(int i=1;i<=(sum>>1);i++)
        {
            tmp=0;
            j=i;
            while(list.size()!=0)//将序列清空
                list.remove(0);
            while(tmp<sum)
            {
                list.add(j);
                tmp+=j++;
                if(tmp==sum)
                    result.add((ArrayList<Integer>) list.clone());
            }
        }
        return result;
    }
}