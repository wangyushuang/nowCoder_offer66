//思路：回溯法
//	沿着某条路径搜索，走不通时，退回到上一点，换条路径索搜
public class serchPathInMatrix {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix.length==0 || matrix.length!=rows*cols || str.length==0)
            return false;
        boolean[] visited=new boolean[matrix.length];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
            {//注意：不需要恢复visited的初始值，因为回溯的过程中已经恢复
                if(hasPathCore(matrix,rows,cols,str,i,j,0,visited))
                    return true;
            }
        return false;
    }
    public boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, int i,int j, int q, boolean[] visited)
    {
        //i-待搜索matrix行标号 j-列标号 q-指向str的指针
        boolean isPath=false;
        if(q==str.length)
            return true;
        if(i<0 || i>=rows || j<0 || j>=cols || visited[i*cols+j])
            return false;
        if(matrix[i*cols+j]==str[q])
        {
            q++;
            visited[i*cols+j]=true;
            isPath=hasPathCore(matrix,rows,cols,str,i+1,j,q,visited) ||
                hasPathCore(matrix,rows,cols,str,i-1,j,q,visited) ||
                hasPathCore(matrix,rows,cols,str,i,j+1,q,visited) ||
                hasPathCore(matrix,rows,cols,str,i,j-1,q,visited);
            if(!isPath)	
                visited[i*cols+j]=false;//回溯
        }
        return isPath;
    }
}