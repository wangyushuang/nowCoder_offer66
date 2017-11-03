//不要用定义的递归方式，时间复杂度O(2^n)
//应当用迭代的方式，时间复杂度O(n)
public class Fibonacci {
    public int fib(int n) {
        int f=0,g=1;//fib(0)和fib(1)
        if(n==0)
            return f;
        while(n-->1){
            g=g+f;
            f=g-f;
        }
        return g;
    }
}