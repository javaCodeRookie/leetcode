package 数组.简单;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/*
    两个数组的交集：给定两个数组，编写一个函数来计算它们的交集。

    示例 1：
        输入：nums1 = [1,2,2,1], nums2 = [2,2]
        输出：[2,2]

    示例 2:
        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        输出：[4,9]

    说明：
        输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
        我们可以不考虑输出结果的顺序。

    进阶：
        如果给定的数组已经排好序呢？你将如何优化你的算法？
        如果 nums1 的大小比 nums2 小很多，哪种方法更优？
        如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

 */
public class 两个数组的交集 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(intersect1(nums1,nums2));
    }

    /**
     * 哈希表
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(min(m,n))
     * 执行用时：3 ms, 在所有 Java 提交中击败了52.85%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了72.11%的用户
     * 通过测试用例：55 / 55
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        //保证容量小的为第一个参数
        if (nums1.length > nums2.length){
            intersect(nums2,nums1);
        }

        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[Math.min(nums1.length,nums2.length)];
        int index = 0;

        //先将第一个数组中的数放入map
        for (int num : nums1) {
            //getOrDefault(V defaultValue)，如果map中已经存在这个key，那么就return这个key对应的value，否则就return defaultValue
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        //遍历第二个数组，假如第二个数组中存在第一个数组中的某个元素，就让count--，但是不能小于0
        for(int num : nums2){
            //存在就取出value，不存在取出0，直接用get的话，key不存在返回null，因为这个题不存在是要按 0 次计算，所以不用get
            int count = map.getOrDefault(num,0);
            if (count > 0){
                res[index] = num;
                count--;
                index++;
                if (count > 0){
                    //如果count自减之后还是大于0，说明第一个数组中这个key是重复的
                    map.put(num,count);
                }else {
                    map.remove(num);
                }

            }
        }

        return Arrays.copyOfRange(res,0,index);
    }


    /**
     * 先排序，再遍历比较（排序+双指针）
     * 时间复杂度：O(mlogm + nlogn)，排序为logm + logn，遍历为 m + n
     * 空间复杂度：O(min(m,n))
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.97%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了49.42%的用户
     * 通过测试用例：55 / 55
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int c1 = 0;//指向nums1的指针
        int c2 = 0;//指向nums2的指针
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[Math.min(len1,len2)];
        int c3 = 0;//指向存放结果的指针

        while (c1 < len1 && c2 < len2){
            if (nums1[c1] < nums2[c2]){
                c1++;
            }else if (nums1[c1] > nums2[c2]){
                c2++;
            }else {
                res[c3] = nums1[c1];
                c1++;
                c2++;
                c3++;
            }
        }
        return Arrays.copyOfRange(res,0,c3);
    }
}