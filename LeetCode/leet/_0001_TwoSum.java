import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoujr
 * created at 2023/6/26 15:08
 * 1.两数之和
 **/
public class _0001_TwoSum {

    public static void main(String[] args) {
        twoSum();
    }

    /**
     * 1.两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     **/
    // https://leetcode.cn/problems/two-sum
    public static void twoSum() {
        System.out.println("1.两数之和");
        int[] nums = new int[]{12, 1, 8, 11, 15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(Arrays.stream(ints).toArray()));
        int[] intsTwo = twoSumTwo(nums, target);
        System.out.println(Arrays.toString(Arrays.stream(intsTwo).toArray()));
    }


    public static int[] twoSum(int[] nums, int target) {
        // 存放数值、下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 补位的数
            int num = target - nums[i];
            // 验证补位的数是否存在
            if (map.containsKey(num)) {
                //补位成功
                return new int[]{map.get(num), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 主要思路是利用hashmap进行补位获取
     * 时间复杂度：
     * 空间复杂度：
     **/
    public static int[] twoSumTwo(int[] nums, int target) {
        // 存放数值、下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 验证补位的数是否存在，利用hashmap验证
            if (map.containsKey(num)) {
                //补位成功
                return new int[]{map.get(num), i};
            }
            // 计算补位数字并存入map
            int coverage = target - num;
            map.put(coverage, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
