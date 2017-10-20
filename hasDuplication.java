public class hasDuplication {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) 
    {
        //为什么要给一个length参数？numbers可能未初始化
        for(int i=0;i<length;i++)
        {
            for(int j=0;j<length;j++)
            {
                if(i!=j && numbers[i]==numbers[j])
                {
                    duplication[0]=numbers[i];
                    return true;
                }
            }
        }
        return false;
    }
}