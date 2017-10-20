import java.util.ArrayList;
//要求：	1.O（1）空间复杂度和O（n）的时间复杂度；
//		  2.除遍历计数器与a[N] b[N]外，不可使用新的变量（包括栈临时变量、堆空间和全局静态变量等）；
//思路：
//	1.B中的每一个元素B[i]都能分解成前后两部分的乘积。
//	2.首先算前一部分：
//		B[0]=1
//		B[1]=B[0]*A[0]
//		B[2]=B[1]*A[1]
//		...
//		B[N]=B[N-1]*A[N-1]
//	3.再算后一部分：(B[0]保存累乘的积)
//		B[N-1]=B[N-1]*A[N]
//		B[N-2]=B[N-2]*A[N]*A[N-1]
//		...
//		B[1]=B[1]*A[N]*...*A[2]
//		B[0]=A[N]*...*A[2]*A[1]

public class productOfArray {
    public int[] multiply(int[] A) 
    {
        int[] B=new int[A.length];
        B[0]=1;
        for(int i=1;i<A.length;i++)
            B[i]=B[i-1]*A[i-1];
        for(int i=A.length-2;i>0;i--)
        {
            B[0]=B[0]*A[i+1];
            B[i]=B[i]*B[0];
        }
        B[0]=B[0]*A[1];
        return B;
    }
}