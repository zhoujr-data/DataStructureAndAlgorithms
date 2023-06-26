/**
 * @author zhoujr
 * created at 2023/6/26 15:41
 * 9. 回文数
 **/
public class _0009_PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber();
    }

    /**
     * 9. 回文数
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     **/
    //https://leetcode.cn/problems/palindrome-number/
    public static void PalindromeNumber() {
        System.out.println("9. 回文数");
        int x = 1221;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindromeSimple(int x) {
        String str = String.valueOf(x);
        String reverse = new StringBuffer(str).reverse().toString();
        return reverse.equals(str);
    }

    /**
     * 主要思路是使用/和%进行获取位数
     * 时间复杂度：O(log n)，对于每次迭代，我们会将输入除以10，因此时间复杂度为O(log n)。
     * 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
     **/
    public static boolean isPalindrome(int x) {
        // x为负数，x不为0并且最后一位为0，不可能是回文数
        if (x < 0 || (x % 10 == 0 && x > 0)) {
            return false;
        }
        int revers = 0;
        // 位数相同最多相等
        while (x > revers) {
            // 前进一位，取最后一位
            revers = revers * 10 + x % 10;
            // 去掉最后一位
            x /= 10;
        }
        // 偶数位位数相等，奇数位多一位
        return x == revers || x == revers / 10;
    }
}
