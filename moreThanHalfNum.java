public class moreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) 
    {
        int len=array.length;
        int halfLen=len>>1;//要考虑halfLen==0的情况        
        if(len==1)
            return array[0];
        int num;
        for(int i=0;i<len;i++)
        {
            num=1;
            for(int j=i+1;j<len;j++)
            {
                if(array[i]==array[j])
                    num++;
                if(num>halfLen)
                    return array[i];
            }
        }
        return 0;
    }
}