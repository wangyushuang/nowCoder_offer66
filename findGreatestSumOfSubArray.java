// 思路：
//     1.假设最大值不包含第一个数，则递归计算除第一个以外的最大值max1
//     2.假设最大值包含第一个数，则累加，计算序列最大值max2
//     3.比较max1和max2，将大的输出
public class findGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) 
    {
        if(array.length<1)
            return 0;
        if(array.length==1)
            return array[0];
        int[] subArr=new int[array.length-1];
        for(int i=1;i<array.length;i++)
            subArr[i-1]=array[i];
        int max1=FindGreatestSumOfSubArray(subArr);//不包含第一个数
        //包含第一个数
        int sum=array[0];
        int max2=array[0];
        for(int i=1;i<array.length;i++)
        {
            sum+=array[i];
            if(sum>max2)
                max2=sum;
        }
        if(max1>=max2)
            return max1;
        else
            return max2;
    }
}