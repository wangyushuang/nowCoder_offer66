public class getNumberOfK {
    public int GetNumberOfK(int [] array , int k) 
    {
        int sum=0;
        for(int i=0;i<array.length;i++)
        {
            if(array[i]>k)
                break;
            if(array[i]==k)
                sum++;
        }
        return sum;
    }
}