package hot100;

public class _070_爬楼梯 {
    /*
        思路：f(i)表示爬到第i阶楼梯的方式，由于每次只能爬1阶或者2阶楼梯，因此爬到第n阶楼梯就是从第n-1阶楼梯或者第n-2阶楼梯爬上去即可
             此题和求最大子数组和的思想
        动态转移方程：f(n) = f(n-1) + f(n - 2)，时间复杂度和空间复杂都都是O(N),
        递归实现：会超时
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    /*
        动态转移方程：f(n) = f(n-1) + f(n - 2)，时间复杂度和空间复杂都都是O(N),可以使用“滚动数组”思想降低空间复杂度：O(1)
        只保留f(n-2)和f(n-1)与f(n)，不需要维护f(n)数组
        p  q  r
        0  0  1 初始化
        0  1  2 第一步 n=1
        1  2  3 第二步 n=2
        2  3  5 第三步 n=3
     */
    public int climbStairs1(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++){
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static void main(String[] args) {
        _070_爬楼梯 obj = new _070_爬楼梯();
        System.out.println(obj.climbStairs(45));
    }
}
