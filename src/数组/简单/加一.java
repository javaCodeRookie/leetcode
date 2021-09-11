package 数组.简单;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1：
 *      输入：digits = [1,2,3]
 *      输出：[1,2,4]
 *      解释：输入数组表示数字 123。
 *
 * 示例 2：
 *      输入：digits = [4,3,2,1]
 *      输出：[4,3,2,2]
 *      解释：输入数组表示数字 4321。
 *
 * 示例 3：
 *      输入：digits = [0]
 *      输出：[1]
 *
 * 提示：
 *      1 <= digits.length <= 100
 *      0 <= digits[i] <= 9
 *
 */
public class 加一 {
    public static void main(String[] args) {
        加一 x = new 加一();
        int[] digits = {9,9,9};
        System.out.println(Arrays.toString(x.plusOne(digits)));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.8 MB, 在所有 Java 提交中击败了62.06%的用户
     * 通过测试用例：
     * 111 / 111
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        int len = digits.length;
        for (int i = len - 1; i >= 0 ; i--) {
            if (digits[i] != 9){
                //因为循环是从最后一位开始的，所以可以这么写
                //首先判断最后一位是否为9，如果不为9这一步执行加一之后就return了
                //如果为9，就执行else，让这一位变成0
                digits[i] += 1;
                return digits;//从后往前数，只要遇见第一个不为9的加一之后return就行了
            }else {
                //某一位如果为9，加一之后就让先让他变为0
                digits[i] = 0;
            }
        }

        //跳出循环说明每一位都是9
        int[] res = new int[len + 1];
        res[0] = 1;
        return res;
    }
}
