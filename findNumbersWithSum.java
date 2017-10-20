import java.util.ArrayList;
public class findNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) 
    {
        ArrayList<Integer> result=new ArrayList<Integer>();
        for(int i=0;i<array.length-1;i++)
            for(int j=i+1;j<array.length;j++)
            {
                if(array[i]+array[j]==sum)
                {
                    result.add(array[i]);
                    result.add(array[j]);
                    return result;
                }
            }
        return result;
    }
}
