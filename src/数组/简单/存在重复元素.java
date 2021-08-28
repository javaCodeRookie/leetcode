package 数组.简单;

import java.util.*;

/*
    给定一个整数数组，判断是否存在重复元素。
    如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false
    示例 1:
        输入: [1,2,3,1]
        输出: true
    示例 2:
        输入: [1,2,3,4]
        输出: false
    示例 3:
        输入: [1,1,1,3,3,4,3,2,4,2]
        输出: true

 */
public class 存在重复元素 {

    public static void main(String[] args) {
        存在重复元素 o = new 存在重复元素();
        int[] nums = {1,2,3,1};
        o.containsDuplicate(nums);
    }

    /**
     * 时间复杂度：O（N）
     * 空间复杂度：O（N）
     * 执行用时：10 ms, 在所有 Java 提交中击败了 9.66% 的用户，因为遍历了一次nums数组，又遍历了一次map的entry
     * 内存消耗：45.1 MB, 在所有 Java 提交中击败了14.76% 的用户
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                Integer count = map.get(nums[i]);
                count++;
                map.put(nums[i],count);
            }else {
                map.put(nums[i],1);//第一次出现的次数应该为1，不是0
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for(Map.Entry<Integer, Integer> entry : entries){
            if (entry.getValue() >= 2)
                return true;
        }
        return false;
    }

    /**
     * 时间复杂度：O（N）
     * 空间复杂度：O（N）
     * 利用Set的去重性，只需要遍历一次 nums 数组就可以了
     * 执行用时：5 ms, 在所有 Java 提交中击败了 62.90% 的用户
     * 内存消耗：42.4 MB, 在所有 Java 提交中击败了 51.53% 的用户
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            if (!set.add(x))//set假如存在某个元素，是不会继续添加的
                return true;
        }
        return false;
    }

    /**
     * 利用排序，假如有重复的元素必然出现在相邻位置
     * 时间复杂度：O(N log N)，其中 N 为数组的长度。需要对数组进行排序。
     * 空间复杂度：O(log N)，其中 N 为数组的长度。注意我们在这里应当考虑递归调用栈的深度。
     * 执行用时：3 ms, 在所有 Java 提交中击败了99.65% 的用户
     * 内存消耗：41.6 MB, 在所有 Java 提交中击败了83.77% 的用户
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {//不是到最后一个索引，否则会出现数组越界
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }
}
