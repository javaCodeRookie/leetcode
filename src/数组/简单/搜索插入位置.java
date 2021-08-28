package 数组.简单;
/*
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    请必须使用时间复杂度为 O(log n) 的算法。

    示例 1:
        输入: nums = [1,3,5,6], target = 5
        输出: 2
    示例2:
        输入: nums = [1,3,5,6], target = 2
        输出: 1
    示例3:
        输入: nums = [1,3,5,6], target = 7
        输出: 4
    示例4:
        输入: nums = [1,3,5,6], target = 0
        输出: 0
    示例 5:
        输入: nums = [1], target = 0
        输出: 0
    提示:
        1 <= nums.length <= 104
        -104 <= nums[i] <= 104
        nums 为无重复元素的升序排列数组
        -104 <= target <= 104

 */
public class 搜索插入位置 {
    public static void main(String[] args) {
        搜索插入位置 o = new 搜索插入位置();
        int[] nums = {1,3,5};
        int target = 1;
        System.out.println(o.searchInsert1(nums,target));
    }

    /**
     * 自己写的，判断条件太多了
     * 0 ms	37.9 MB
     * 时间复杂度要求为O（log n），只能用二分法
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {

        int len = nums.length;
        //最左边和最右边单独拿出来考虑
        if (target <= nums[0]){
            return 0;
        }
        if (target == nums[len - 1])
            return len - 1;
        if (target > nums[len - 1]){
            return len;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right){
            mid = (left + right) / 2;

            if (nums[mid] == target){
                break;
            }
            if (nums[mid] > target){
                right = mid;
            }else {
                left = mid;
            }
            if (right - left == 1){
                mid = right;
                break;
            }
        }
        return mid;
    }

    /**
     * 力扣大神写的
     * 本题关键：在区间 nums[left..right] 里查找第 1 个大于等于 target 的元素的下标，这样就不用进行边界判断了
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len;
        while (left < right){
            //在区间 nums[left..right] 里查找第 1 个大于等于 target 的元素的下标
            //int mid = (left + right) >>> 1;
            //这是参考 Java 的 JDK 中 Arrays.binarySearch() 函数的写法。
            //理由是 left + right 即使是在整型溢出以后，由于无符号右移 >>> 1 ，仍然能够得到正确的结果
            //虽然 >> 1 和 /2 ，但是有些语言编译器都会将 /2 转换成位运算的操作，这是编译器内部的优化。
            // 因此我们没有必要手动去做这一步优化，写代码的时候还是写 / 2。
            int mid = left + (right - left) / 2;//这么写是为了防止left + right溢出
            if (nums[mid] >= target){
                // 下一轮搜索的区间是 [left..mid]
                right = mid;
            }else {
                // 下一轮搜索的区间是 [mid + 1..right]
                left = mid + 1;
            }
        }
        return left;
    }
}
