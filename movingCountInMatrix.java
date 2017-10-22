//回溯法
public class movingCountInMatrix {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean [][] visited=new boolean[rows][cols];
        movingCore(threshold,rows,cols,0,0,visited);
        int sum=0;
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                if(visited[i][j])
                    sum++;
        return sum;
    }
    public void movingCore(int threshold, int rows, int cols, int p, int q, boolean [][] visited)
    {
        //移动到p行q列
        if(p<0 || p>=rows || q<0 || q>=cols || visited[p][q])
            return;
        int sum=0;
        int tmp1=p;
        int tmp2=q;
        while(tmp1>0)
        {
            sum+=tmp1%10;
            tmp1/=10;
        }
        while(tmp2>0)
        {
            sum+=tmp2%10;
            tmp2/=10;
        }
        if(sum<=threshold)
        {
            visited[p][q]=true;
            movingCore(threshold,rows,cols,p-1,q,visited);
            movingCore(threshold,rows,cols,p+1,q,visited);
            movingCore(threshold,rows,cols,p,q-1,visited);
            movingCore(threshold,rows,cols,p,q+1,visited);
        }
    }
}