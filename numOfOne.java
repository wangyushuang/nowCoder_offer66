public class numOfOne 
{
    public int NumberOf1(int n) 
    {
        int i=1;
        int count=0;
        while(i!=0)
        {
            if((i&n)!=0)
                count++;
            i<<=1;
        }
        return count;
    }
}