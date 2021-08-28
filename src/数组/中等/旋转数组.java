package 数组.中等;

import java.util.Arrays;

/*
    给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
    进阶：
        尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
        你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
    示例 1：
        输入: nums = [1,2,3,4,5,6,7], k = 3
        输出: [5,6,7,1,2,3,4]
        解释:
            向右旋转 1 步: [7,1,2,3,4,5,6]
            向右旋转 2 步: [6,7,1,2,3,4,5]
            向右旋转 3 步: [5,6,7,1,2,3,4]
    示例 2:
        输入：nums = [-1,-100,3,99], k = 2
        输出：[3,99,-1,-100]
        解释:
            向右旋转 1 步: [99,-1,-100,3]
            向右旋转 2 步: [3,99,-1,-100]
    提示：
        1 <= nums.length <= 2 * 104
        -231 <= nums[i] <= 231 - 1
        0 <= k <= 105
 */
public class 旋转数组 {
    public static void main(String[] args) {
        旋转数组 o = new 旋转数组();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 9;
        o.rotate(nums,k);
    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * 执行用时：1 ms, 在所有 Java 提交中击败了 63.65% 的用户
     * 内存消耗：55 MB, 在所有 Java 提交中击败了 88.18% 的用户
     * @param nums
     * @param k
     */
    //方法一：新建数组
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            //体会取模的含义，凡是超出某一个长度，但是还想让它的位置保持不变，就使用取模
            res[(i + k) % len] = nums[i];//取模就可以防止数据溢出，即使 k > len 也适用
        }
        System.arraycopy(res,0,nums,0,len);//将新数组的元素拷贝到原来的数组中
        System.out.println(Arrays.toString(nums));
        // k > len就不适用了
//        for (int i = 0; i < k; i++) {
//            res[i] = nums[len - k + i];
//        }
//        for (int i = 0; i < nums.length - k; i++) {
//            res[i + k] = nums[i];
//        }

    }

    /**
     * 时间复杂度：每个元素翻转两次，O(2N) = O(N)
     * 空间复杂度：O(1)
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：55.5 MB, 在所有 Java 提交中击败了12.53% 的用户
     * @param nums
     * @param k
     */
    //方法二：数组翻转，先将整个数组翻转，然后再翻转 k mod n （左半部分），再翻转 k mod n -- n - 1
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);//end应为 k-1（因为索引是从0开始的），不是 k，
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        int tmp;
        while (start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start += 1;
            end -= 1;
        }
    }


    //方法三：环状替换
    public void rotate2(int[] nums, int k) {

    }
}
