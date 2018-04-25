package LinkedList;

import Nqueen.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class deleteCycle {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> record = new HashSet<>();
        ListNode a = head;
        while (a != null) {
            if (record.contains(a)) break;
            record.add(a);
            a = a.next;
        }
        if (a == null) return null;
        return a;
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        // 找到快慢指针相遇的地方
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int find = 0;
        // 用一个新指针从头开始，直到和慢指针相遇
        while (find != slow) {
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }
    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i : nums) {
            if (nums[Math.abs(i) - 1] < 0) res[0] = Math.abs(i);
            else nums[Math.abs(i) - 1] *= -1;
        }
        for (int i=0;i<nums.length;i++) {
            if (nums[i] > 0) res[1] = i+1;
        }
        return res;
    }

    public int[] findErrorNums2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int duplicate = 0, n = nums.length;
        long sum = (n * (n+1)) / 2;
        for(int i : nums) {
            if(set.contains(i)) duplicate = i;
            sum -= i;
            set.add(i);
        }
        return new int[] {duplicate, (int)sum + duplicate};
    }
    public static void main(String[] args) {
        int[] a = {3, 7, 6, 5, 2, 4, 1, 9, 7, 8, 4, 13};
        findDuplicate(a);
        findErrorNums(new int[]{2,3,3,4,5,6});

        Object obj = new Object();
        System.gc();
        System.out.println();
        obj =new Object();
        obj = new Object();
        System.gc();
        System.out.println();
    }
}
