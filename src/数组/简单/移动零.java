package 数组.简单;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *      输入: [0,1,0,3,12]
 *      输出: [1,3,12,0,0]
 * 说明:
 *      必须在原数组上操作，不能拷贝额外的数组。
 *      尽量减少操作次数。（至少得遍历一次数组）
 */
public class 移动零 {

    public static void main(String[] args) {
        移动零 obj = new 移动零();
        int[] nums = {0,1};
        obj.moveZeroes(nums);
    }

    /**
     * 双指针
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了17.68%的用户
     * 通过测试用例：21 / 21
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        int slow = 0;
        int fast = 0;
        while (fast < nums.length - 1){
            if (nums[fast] != 0){//假如数组中没有0
                //快慢指针都从第一个为0的数字开始计算
                fast++;
                slow++;
                continue;
            }else {
                while (nums[fast] == 0 && fast < nums.length - 1){
                    fast++;
                }
                nums[slow] = nums[fast];
                nums[fast] = 0;
                slow++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
