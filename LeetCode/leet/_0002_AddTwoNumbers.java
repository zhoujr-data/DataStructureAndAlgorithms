import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoujr
 * created at 2023/6/26 15:25
 * 2.两数相加
 **/
public class _0002_AddTwoNumbers {
    public static void main(String[] args) {
        addTwoNumbers();
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
}
