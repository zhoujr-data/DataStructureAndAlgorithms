import java.util.*;

/**
 * @author zhoujr
 * created at 2022/8/31 15:18
 * 数组
 **/
public class Array {

    public static void main(String[] args) {
        // 1.两数之和
        twoSum();
        // 2.两数相加
        addTwoNumbers();
        // 3.无重复字符的最长子串
        lengthOfLongestSubstring();
    }

    public static void twoSum() {
        System.out.println("1.两数之和");
        int[] nums = new int[]{12, 1, 8, 11, 15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(Arrays.stream(ints).toArray()));

    }


    /**
     * 1.两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     **/
    // https://leetcode.cn/problems/two-sum
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

    public static void addTwoNumbers() {
        System.out.println("2.两数相加");
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);


        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode addNode = addTwoNumbers(l1, l2);
        List<Integer> list = new ArrayList<>();
        while (addNode != null) {
            list.add(addNode.val);
            addNode = addNode.next;
        }
        System.out.println(list);
    }

    /**
     * 2.两数相加（预先指针）
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     **/
    // https://leetcode.cn/problems/add-two-numbers
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 头指针（伪指针）
        ListNode pre = new ListNode(0);
        // 可移动指针
        ListNode cur = pre;
        // 进位数
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 把当前位相加
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            // 试算是否进位
            carry = sum / 10;
            // 取余当前位数
            sum = sum % 10;
            // 添加节点
            cur.next = new ListNode(sum);
            // 节点后移
            cur = cur.next;

            // l1\l2节点后移
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // 最后一位相加大于10，进位
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return pre.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void lengthOfLongestSubstring() {
        System.out.println("3.无重复字符的最长子串");
        String s1 = "abcabcb";
        int i = lengthOfLongestSubstring(s1);
        System.out.println(i);
        String s2 = "bbbbb";
        int i2 = lengthOfLongestSubstring(s2);
        System.out.println(i2);
    }

    /**
     * 3.无重复字符的最长子串（滑动窗口）
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     **/
    public static int lengthOfLongestSubstring(String s) {
        // 最大长度
        int ans = 0;
        // 字符，下标+1
        Map<Character, Integer> map = new HashMap<>();
        // 滑窗
        for (int start = 0, end = 0; end < s.length(); end++) {
            // 取当前字符
            char alpha = s.charAt(end);

            if (map.containsKey(alpha)) {
                // 重复了，更新滑窗开始位置
                start = Math.max(map.get(alpha), start);
            }
            // 取最大连续不重复长度
            ans = Math.max(ans, end - start +1);
            // 更新到当前字符串最大下表
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}
