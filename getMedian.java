import java.util.ArrayList;
public class getMedian {
	ArrayList<Integer> list=new ArrayList<Integer>();
    public void Insert(Integer num) 
    {
        if(list.size()==0)
            list.add(num);
        else
        {
            for(int i=0;i<list.size();i++)
            {
                if(num<=list.get(i))
                {
                    list.add(i,num);
                    return;
                }
            }
            list.add(num);//大于所有数
        }
    }

    public Double GetMedian() 
    {
        int size=list.size();
        return (size%2==0)?((list.get(size/2-1)+list.get(size/2))/2.0):1.0*(list.get(size/2));
    }
}