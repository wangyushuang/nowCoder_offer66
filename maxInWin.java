import java.util.ArrayList;
public class maxInWin {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(num.length==0 || size==0 || size>num.length)
            return result;
        int max;
        for(int i=0;i<=num.length-size;i++)
        {
            max=num[i];
            for(int j=1;j<size;j++)
            {
                if(num[i+j]>max)
                    max=num[i+j];
            }
            result.add(max);
        }
        return result;
    }
}
