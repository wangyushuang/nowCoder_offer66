//思路：
//	1.将numbers从小到大排列，并累加相邻正数的差sum
//		若有相同的非零数字，返回false
//	2.如果sum小于牌的张数，则返回true
public class continuous {
    public boolean isContinuous(int [] numbers) 
    {
        //冒泡法排序
        for(int i=0;i<numbers.length-1;i++)
            for(int j=0;j<numbers.length-1-i;j++)
            {
                if(numbers[j]!=0 && numbers[j]==numbers[j+1])
                    return false;//存在相同的非零数字
                if(numbers[j]>numbers[j+1])
                {
                    int tmp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=tmp;
                }
            }
        //累加相邻数之间的差(0不用计算)
        int sum=0;
        for(int i=1;i<numbers.length;i++)
        {
            if(numbers[i-1]!=0)
            	sum+=numbers[i]-numbers[i-1];
        }
        return sum<numbers.length;
    }
}
