//思路：
//	1.1作为丑数的源，通过乘以2、3或5，不断生成新的丑数
//	2.每一个丑数都要乘以2、3和5，去生成新的丑数
public class getUglyNumber {
    public int GetUglyNumber_Solution(int index) 
    {
        if(index<=0)
            return 0;//输入不合法
        int num=1;//丑数序号
        int i=0,j=0,k=0;//从第一个丑数开始
        int [] ugNum=new int[index];//从小到大存储丑数
        ugNum[0]=1;//第一个丑数
        int tmp1,tmp2,tmp3;
        int minVal;
        while(num<index)
        {
            tmp1=2*ugNum[i];
            tmp2=3*ugNum[j];
            tmp3=5*ugNum[k];
            minVal=tmp1;//当前丑数
            if(tmp2<minVal)
                minVal=tmp2;
            if(tmp3<minVal)
                minVal=tmp3;
            ugNum[num++]=minVal;
            //若第i个丑数*2小于等于当前丑数，则看下一个丑数
            while(ugNum[i]*2<=minVal) i++;
            while(ugNum[j]*3<=minVal) j++;
            while(ugNum[k]*5<=minVal) k++;
        }
        return ugNum[index-1];
    }
}