// 思路：
//     1.1到100：个位上1的个数  →1
//     2.1到100：十位上1的个数  →10
//     3.1到1000：百位上1的个数 →100
//     ......
//     tmp从最低位取到最高位：判断tmp位上1的个数。
// 例如：n=2017
//     个位：7>1,sum+=(201+1)*1
//     十位：1=1,sum+=20*10+7+1
//     百位：0<1,sum+=2*100
//     千位：2>1,sum+=(0+1)*1000
public class numberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) 
    {
        int sum=0;
        int p,q,tmp;
        for(int i=1;i<=n;i*=10)
        {
            p=n/(i*10);//商
            q=n%(i*10);//余数
            tmp=q/i;//余数的最高位
            if(tmp>1)
            {
                sum+=(p+1)*i;
            }
            if(tmp==1)
            {
                sum+=p*i+q-i+1;
            }
            if(tmp<1)
            {
                sum+=p*i;
            }
        }
        return sum;
    }
}