import java.util.ArrayList;
public class verifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)
            return false;
        if(sequence.length==1)
            return true;
        int root=sequence[sequence.length-1];
        ArrayList<Integer> left=new ArrayList<Integer>();
        ArrayList<Integer> right=new ArrayList<Integer>();
        boolean flag=false;
        for(int i=0;i<sequence.length-1;i++)
        {
            if(!flag && sequence[i]<root)//左子树
                left.add(sequence[i]);
            if(!flag && sequence[i]>root)//右子树第一个元素
                flag=true;
            if(flag)
                if(sequence[i]<root)//右子树中有值小于根的元素
                	return false;
            	else
                    right.add(sequence[i]);
        }
        int [] leftArr=new int[left.size()];
        int [] rightArr=new int[right.size()];
        //将ArrayList转化为数组(int[])
        for(int i=0;i<left.size();i++)
            leftArr[i]=left.get(i);
        for(int i=0;i<right.size();i++)
            rightArr[i]=right.get(i);
        if(leftArr.length>0 && rightArr.length>0)//左右子树都非空
        	return VerifySquenceOfBST(leftArr)&& VerifySquenceOfBST(rightArr);
        if(leftArr.length>0)
            return VerifySquenceOfBST(leftArr);//左子树非空
        else 
            return VerifySquenceOfBST(rightArr);//右子树非空
    }
}