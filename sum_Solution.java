//思路：关键在于判断n是否为0
//		可以用布尔表达式
public class sum_Solution {
    public int Sum_Solution(int n) 
    {
        int sum=0;
        boolean f=(n==0 || (sum=Sum_Solution(n-1))>0);
        return n+sum;
    }
}