//思路：
    // 1.首先确定矩阵4个顶点位置，如果顶点不重合，则按顺时针打印最外圈，并将顶点向内移动。
    // 2.如果左顶点与右顶点重合，且上下顶点不重合，则打印这一列。
    // 3.如果上顶点与下顶点重合，且左右顶点不重合，则打印这一行。
    // 4.如果四个顶点都重合，则打印这一一个数。
import java.util.ArrayList;
public class printMat {
    public ArrayList<Integer> printMatrix(int [][] matrix) 
    {
        ArrayList<Integer> list=new ArrayList<Integer>();
        int left=0,right=matrix[0].length-1,up=0,down=matrix.length-1;
        while(right>left && down>up)
        {
            for(int i=left;i<=right;i++)
            {
                list.add(matrix[up][i]);
            }
            for(int i=up+1;i<=down;i++)
            {
                list.add(matrix[i][right]);
            }
            for(int i=right-1;i>=left;i--)
            {
                list.add(matrix[down][i]);
            }
            for(int i=down-1;i>=up+1;i--)
            {
                list.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        if(left==right && down>up)//一列
        {
            for(int i=up;i<=down;i++)
                list.add(matrix[i][left]);
        }
        if(up==down && right>left)//一行
        {
            for(int i=left;i<=right;i++)
                list.add(matrix[up][i]);
        }
        if(up==down && left==right)//一个数 
            list.add(matrix[up][left]);
        return list;
    }
}