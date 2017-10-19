//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class findNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) 
    {
        boolean flag=false;
        boolean numFlag=false;//true-num1已经找到
        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<array.length;j++)
            {
                flag=false;
                if(i!=j && array[i]==array[j])
                {
                    flag=true;//该数字出现两次
                    break;
                }
            }
            if(!flag && !numFlag)//找到第一个
            {
                numFlag=true;
                num1[0]=array[i];
                continue;
            }
            if(!flag && numFlag)
            {
                num2[0]=array[i];
                break;
            }
        }
    }
}