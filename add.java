//思路：利用硬件带进位加法器的思想
public class add {
    public int Add(int num1,int num2) 
    {
        int sum  = num1 ^ num2;
        int carry= (num1 & num2)<<1;//进位
        if(carry==0)
            return sum;
        else
            return Add(sum,carry);
    }
}