import java.util.ArrayList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
//注意：题目没有说TreeNode的val是正数还是负数
//思路：
//	1.如果root是叶子节点,判断sum是否等于target，
//		1.1 如果等于，将route移入routes
//		1.2 如果不等于，进入1.3
//		1.3 清除root的信息：更新route和sum
//	2.如果root不是叶子节点，则递归判断root的左右子树是否包含路径。
public class findPath {
    ArrayList<Integer> route=new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> routes =new ArrayList<ArrayList<Integer>>();
    int sum=0;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) 
    {
        if(root==null)
            return routes;
        sum+=root.val;
        route.add(root.val);
        boolean isLeaf=((root.left==null)&&(root.right==null));
        if(isLeaf && sum==target)
        {
            routes.add((ArrayList<Integer>) route.clone());
        }
        if(root.left!=null)
            FindPath(root.left,target);
        if(root.right!=null)
            FindPath(root.right,target);
        route.remove(route.size()-1); 
        sum-=root.val;
        return routes;
    }
}