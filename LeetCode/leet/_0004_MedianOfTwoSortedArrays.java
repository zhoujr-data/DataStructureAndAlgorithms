/**
 * @author zhoujr
 * created at 2022/8/31 15:18
 * 4.寻找两个正序数组的中位数
 **/
public class _0004_MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        findMedianSortedArrays();
    }


    public static void findMedianSortedArrays() {
        System.out.println("4.寻找两个正序数组的中位数");
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};

        double v1 = test01(nums1, nums2);
        System.out.println("test01：" + v1);

        double v2 = test02(nums1, nums2);
        System.out.println("test01：" + v2);

        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);


    }

    /**
     * 4.寻找两个正序数组的中位数
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     **/
    // https://leetcode.cn/problems/median-of-two-sorted-arrays
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) +
                getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int l1 = end1 - start1 + 1;
        int l2 = end2 - start2 + 1;
        if (l1 > l2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (l1 == 0) return nums2[start2 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(l1, k / 2) - 1;
        int j = start2 + Math.min(l2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    public static double test02(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        int len = a + b;
        int left = -1, right = -1;
        int aIndex = 0, bIndex = 0;
        // 遍历总长一半，奇数到总长-1的一半
        for (int i = 0; i <= len / 2; i++) {
            // 右侧赋值给左侧
            left = right;
            // a索引小于数组a的长度，并且b索引大于等于b的长度 或 a索引处值小于b索引处值
            // 比较两个数组值的大小，依次向后寻找中位数
            if (aIndex < a && (bIndex >= b || nums1[aIndex] < nums2[bIndex])) {
                // 右侧等一a索引处值
                // a索引后移
                right = nums1[aIndex++];
            } else {
                // b索引后移
                // 右侧等一a索引处值
                right = nums2[bIndex++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

    public static double test01(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        int count = 0;
        if (m == 0) {
            count = n;
            nums = nums2;
        } else if (n == 0) {
            count = m;
            nums = nums1;
        } else {
            int i = 0, j = 0;
            while (count != (m + n)) {
                if (i == m) {
                    while (j != n) {
                        nums[count++] = nums2[j++];
                    }
                    break;
                }
                if (j == n) {
                    while (i != m) {
                        nums[count++] = nums1[i++];
                    }
                    break;
                }
                if (nums1[i] < nums2[j]) {
                    nums[count++] = nums1[i++];
                } else {
                    nums[count++] = nums2[j++];
                }
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

}
