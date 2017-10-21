import java.util.ArrayList;
public class firstAppearingOnce {
    //Insert one char from stringstream
    ArrayList<Character> chList=new ArrayList<Character>();
    ArrayList<Character> apOnce=new ArrayList<Character>();
    public void Insert(char ch)
    {
        boolean flag=false;
        for(int i=0;i<apOnce.size();i++)
            if(ch==apOnce.get(i))
            {
                apOnce.remove(i);
                flag=true;
                break;
            }
        if(!flag)//apOnce不包含ch
            apOnce.add(ch);
        chList.add(ch);
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if(apOnce.size()==0)
            return '#';
        else
            return apOnce.get(0);
    }
}