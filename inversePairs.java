//思路：由于array非常大，而时间和内存有限，
//		不能使用冒泡排序，否则超出时间限制
//		尽量不要创建新的数组，否则超出内存限制
//		使用归并排序
//	1.将array分为两部分，前半部分为part1，后半部分为part2，都为从小到大顺序排列
//	2.递归：part1中逆序对数目为num1，part2中逆序对数目为num2
//	3.计算part1和part2之间的逆序对数目num3，
//		同时，将part1和part2合并成一个从小到大排列的数组，赋给array
//	4.返回num1+num2+num3
public class inversePairs {
    public int InversePairs(int [] array) 
    {
        return separateMerge(array,0,array.length-1);
    }
    public int separateMerge(int [] array, int first, int last)
    {
        if(last<=first)
            return 0;
        int mid=(first+last)>>1;
        int [] merge=new int[last-first+1];//合并后的矩阵，从大到小排列
        int num1=separateMerge(array,first,mid);	//part1中逆序对数目
        int num2=separateMerge(array,mid+1,last);	//part2中逆序对数目
        int num3=0;	//part1和part2之间的逆序对数目
        int p=mid;	//part1的指针
        int q=last;	//part2的指针
        int c=0;	//merge的指针
        while(p>=first && q>=mid+1)
        {
            if(array[p]>array[q])
            {
                num3+=q-mid;
                if(num3>=1000000007)
                    num3=num3-1000000007;
                merge[c++]=array[p--];
            }
            else
                merge[c++]=array[q--];
        }
        while(p>=first) merge[c++]=array[p--];
        while(q>=mid+1) merge[c++]=array[q--];
        for(int i=0;i<=last-first;i++)//将merge翻转，赋值给array对应段
            array[first+i]=merge[last-first-i];
        int result=num1+num2+num3;
        while(result>=1000000007) result=result-1000000007;
        return result;
    }
}