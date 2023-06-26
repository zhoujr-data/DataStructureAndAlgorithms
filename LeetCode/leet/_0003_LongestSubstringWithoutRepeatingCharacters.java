import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoujr
 * created at 2023/6/26 15:27
 * 3.无重复字符的最长子串
 **/
public class _0003_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        lengthOfLongestSubstring();
    }

    public static void lengthOfLongestSubstring() {
        System.out.println("3.无重复字符的最长子串");
        String s1 = "pwwkew";
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
        // 不重复字符，最大下标+1
        Map<Character, Integer> map = new HashMap<>();
        // 滑窗
        for (int start = 0, end = 0; end < s.length(); end++) {
            // 取当前字符
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                // 出现重复，重置滑窗开始位置下标
                // 上一个相同字符下标+1可能会在开始位置之前，所以比较取最大
                start = Math.max(map.get(alpha), start);
            }
            // 上一段最大长度和当前长度取最大
            ans = Math.max(ans, end - start + 1);
            // 更新到当前字符串最大下标+1
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}
