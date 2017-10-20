//思路：
//	1.创建一个动态数组circ,将所有小朋友的编号存入circ
//	2.circ中，每隔m就删掉一个编号，不断循环，直到只剩下一个编号，
//		输出该编号
import java.util.ArrayList;
public class lastRemaining {
    public int LastRemaining_Solution(int n, int m) 
    {
        if(n==0 || m==0)//输入不合法
            return -1;
        ArrayList<Integer> circ=new ArrayList<Integer>();
        for(int i=0;i<n;i++) //小朋友标号放入圈中
            circ.add(i);
        int p=m-1;	//指向小朋友编号的指针
        while(circ.size()>1)
        {
            while(p>=circ.size()) p-=circ.size();//注意：不是减n
            circ.remove(p);
            p--;//由于删掉了一个元素，指针向前移一位
            p+=m;
        }
        return circ.get(0);
    }
}