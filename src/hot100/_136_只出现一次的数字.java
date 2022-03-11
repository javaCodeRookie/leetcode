package hot100;

import java.util.*;

public class _136_只出现一次的数字 {
    /*
        思路一：先将数组进行排序，再使用栈，栈中最后的那个数字就是出现一次的数字
               时间复杂度：O(N)，遍历数组
               空间复杂度：O(N)，需要额外的栈空间来存放
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        Deque<Integer> stack = new LinkedList<>();
        for (int x : nums) {
            if (!stack.isEmpty() && x == stack.peek()){
                stack.pop();
            }else {
                stack.push(x);
            }
        }
        return stack.pop();
    }

    /*
        思路二：使用哈希表代替栈，并且不需要排序，运行时间相对于栈肯定会降低，key：数字，value：次数
        时间复杂度与空间复杂度也是O(N)
     */
    public int singleNumber1(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else {
                map.put(nums[i], 2);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }

    /*
        思路三：不使用额外空间，使用按位异或，相同为0，不同为1
               异或性质：任何一个数与0异或都是本身
                        自身与自身异或都是0
                        异或满足交换律
                        a ^ b ^ a ^ b ^ c = (a ^ a) ^ (b ^ b) ^ c = c，所以数组全部异或之后得出的结果就是出现一次的数字
               时间复杂度：O(N)，需要遍历整个数组
               空间复杂度：O(1)，不需要额外空间，
        这个思路是真的妙，真是没有想到
     */
    public int singleNumber2(int[] nums){
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        _136_只出现一次的数字 obj = new _136_只出现一次的数字();
        int[] nums = new int[]{2,1,2,1,0,0,5,5,6};
        System.out.println(obj.singleNumber(nums));
    }
}
