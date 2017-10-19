// 思路：递归、交换
//     1. 第i个字母不变，递归排列i后面的字母
//     2. 将第i个字母与后面的字母逐个交换(在字母不同的情况下)，递归排列i后面的字母
import java.util.ArrayList;
import java.util.Collections;
public class permutation {
    public ArrayList<String> Permutation(String str) 
    {
        char[] chArr=str.toCharArray();
        ArrayList<String> result=new ArrayList<String>();
        if(chArr.length==0)
            return result;
        Permu(chArr,0,result);
        Collections.sort(result);
        return result;
    }
    public void Permu(char [] chArr, int i, ArrayList<String> list)
    {
        if(i==chArr.length-1)
        {
            if(!list.contains(String.valueOf(chArr)))//考虑只有一个字符的情况
            	list.add(String.valueOf(chArr));
            return ;
        }
        Permu(chArr,i+1,list);//第i个字母不变
        for(int j=i+1;j<chArr.length;j++)//第i个字母与后面字母交换位置
        {
            if(chArr[i]!=chArr[j])
            {
                char tmp=chArr[i];
                chArr[i]=chArr[j];
                chArr[j]=tmp;
                
                list.add(String.valueOf(chArr));
                Permu(chArr,i+1,list);
                
                tmp=chArr[i];
                chArr[i]=chArr[j];
                chArr[j]=tmp;
            }
        }
    }
}