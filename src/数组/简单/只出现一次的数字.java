package 数组.简单;

import java.util.*;

/*
    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    说明：你的算法应该具有线性时间复杂度，即时间复杂度为O(N)。 你可以不使用额外空间来实现吗？
    示例 1:
        输入: [2,2,1]
        输出: 1
    示例 2:
        输入: [4,1,2,1,2]
        输出: 4

 */
public class 只出现一次的数字 {
    public static void main(String[] args) {
        只出现一次的数字 o = new 只出现一次的数字();
        int[] nums = new int[]{4,1,2,4,2};
        System.out.println(o.singleNumber1(nums));

    }


    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了64.76%的用户
     * 时间复杂度：O(N)
     * 空间辅助度：O(1)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        /*
            a^a = 0
            a^0 = a
            交换律：a^b^c = a^c^b
            结合律：a^b^c = a^(b^c)
         */
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            res ^= nums[i];
        }
        return res;
    }

    /**
     * 使用Set集合解决，使用了额外的内存空间
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * 执行用时：9 ms, 在所有 Java 提交中击败了 20.14% 的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了 35.48% 的用户
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //添加失败说明该值在 set 集合中已经存在，需要将其从set中删除
            if (!set.add(nums[i])){
                set.remove(nums[i]);
            }
        }
        //返回set中唯一存在的值就可以
        return (int)set.toArray()[0];
    }

}
