
/**
 * Created by Storm on 18/2/23.
 */

import java.util.*;

//90:Subset2
public class ListNodes {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rec = new ArrayList<>();
        if (nums == null || nums.length == 0) return rec;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        dfs(rec, list, 0, nums);
        return rec;
    }

    public void dfs(List<List<Integer>> rec, List<Integer> list, int start, int[] nums) {
        if (!rec.contains(list)) {
            rec.add(new ArrayList<>(list));
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            dfs(rec, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }

    public void two_sum(int[] nums, int i, int target, List<List<Integer>> result) {
        //sorted
        int j = nums.length - 1;
        int b = i - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                result.add(Arrays.asList(nums[i], nums[j], nums[b]));
                i++;
                j--;
                while (i < j && nums[i] == nums[i - 1]) i++;
                while (i < j && nums[j] == nums[j + 1]) j--;
            } else {
                if (nums[i] + nums[j] < target)
                    i++;
                j--;

            }
        }
        return;
    }


    public List<List<Integer>> three_sum(int[] nums, int target) {
        List<List<Integer>> rec = new ArrayList<>();
        List<Integer> re = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i + 1] == nums[i])
                continue;
            else
                two_sum(nums, i + 1, target - nums[i], rec);
        }
        return rec;
    }

    public static int numDecodings1(String s) {
        char[] charset = s.toCharArray();
        int sum = 1;
        for (int i = 0; i < charset.length - 1; i++) {
            //
            int multipy = 1;
            int a = (int) charset[i] - 48;
            int b = (int) charset[i + 1] - 48;
            if (a * 10 + b <= 26) {
                multipy = 2;
                sum = sum * multipy;
                continue;
            }
        }
        return sum;
    }


    public int numDecodings(String s) {
        return s.isEmpty() ? 0 : numDecodings(0, s);
    }

    int numDecodings(int num, String s) {
        int n = s.length();
        if (num == n) return 1;
        if (s.charAt(num) == '0') return 0;
        int rec = numDecodings(num + 1, s);
        if (num < n - 1 && s.charAt(num) == '1' || s.charAt(num) == '2' && s.charAt(num) < '7')
            rec += numDecodings(num + 2, s);
        return rec;
    }

    //LeetCode 92
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for (int i = 0; i < m - 1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;

            System.out.println();
            ListNode make1 = new ListNode(0);
            make1.next = head;
            while (make1 != null) {
                System.out.print(make1.val + " ");
                make1 = make1.next;
            }

            then.next = pre.next;

            System.out.println();
            ListNode make2 = new ListNode(0);
            make2.next = head;
            while (make2 != null) {
                System.out.print(make2.val + " ");
                make2 = make2.next;
            }

            pre.next = then;

            System.out.println();
            ListNode make3 = new ListNode(0);
            make3.next = head;
            while (make3 != null) {
                System.out.print(make3.val + " ");
                make3 = make3.next;
            }

            then = start.next;
            System.out.println();
            ListNode make = new ListNode(0);
            make.next = head;
            while (make != null) {
                System.out.print(make.val + " ");
                make = make.next;
            }

            System.out.println("------------------");
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;
    }

    private static ListNode buildListNode(int[] a) {

        ListNode first = null, last = null, newNode;
        int num;
        if (a.length > 0) {
            for (int i = 0; i < a.length; i++) {
                newNode = new ListNode(a[i]);
                newNode.next = null;
                if (first == null) {
                    first = newNode;
                    last = newNode;
                } else {
                    last.next = newNode;
//                    System.out.println(last.val);
                    last = newNode;
//                    System.out.println(last.val);
                }
            }
        }
        return first;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        while (head == null) return null;
        ListNode rec = new ListNode(0);
        rec.next = head;
        ListNode fast = new ListNode(0), low = new ListNode(0);
        fast.next = head;
        low.next = head;
        fast = fast.next.next;
        low = low.next;
        while (fast != null) {

            if (fast.val == low.val) {
                fast = fast.next;
                low.next = fast;
            } else {
                low = fast;
                fast = fast.next;
            }
//            System.out.print(low.val + " ");
        }
        return rec.next;
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        if (head.next == null || head.next.next == null) return head;
        ListNode fast = head, low = head, saveForfast = head, zero = head;
//fast=new ListNode(0);fast.next=head
//low=new ListNode(0);
//saveForfast=new ListNode(0);
//zero=new ListNode(0);
//fast=fast.next.next;
//low=
        fast = fast.next;
        saveForfast = fast;
        //等fast 到了最后一个的情况
        while (fast.next != null) {
            ListNode temp = fast.next;
            if (fast.next.next == null) {
                low.next = fast.next;
                fast.next = null;
                low = low.next;
                break;
            }
            fast.next = fast.next.next;
            fast = fast.next;
            low.next = temp;
            low = low.next;
            low.next = fast;
        }
        low.next = saveForfast;
        return head;

    }

    public static ListNode partition(ListNode head, int x) {
        ListNode o1 = new ListNode(0);
        ListNode o0 = o1;
        ListNode o2 = new ListNode(0);
        ListNode o3 = o2;
        ListNode move = head;
        while (move != null) {
            if (move.val < x) {
                o1.next = move;
                o1 = o1.next;
                move = move.next;
                o1.next = null;
            } else {
                o2.next = move;
                o2 = o2.next;
                move = move.next;
                o2.next = null;
            }
        }
        o1.next = o3.next;
        return o0.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode v = result;
        List<Integer> rec = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode a = new ListNode(0);
            a = lists[i];
            while (a != null) {
                rec.add(lists[i].val);
            }
        }
        Collections.sort(rec);
        for (int i = 0; i < rec.size(); i++) {
            result.next = new ListNode(rec.get(i));
            result = result.next;
        }
        return v.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) return null;
        int n = lists.length;
        while (n > 1) {
            int k = (n + 1) / 2;
            for (int i = 0; i < n / 2; ++i) {
                lists[i] = mergeTWOLists(lists[i], lists[i + k]);
            }
            n = k;
        }
        return lists[0];
    }

    public ListNode mergeTWOLists(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (a != null && b != null) {
            if (a.val < b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }
        if (a != null) current.next = a;
        if (b != null) current.next = b;
        return head.next;
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode move1 = new ListNode(0);
        ListNode move2 = new ListNode(0);
        move1 = head;
        move2 = head.next;
        while (move1.next != null && move2.next != null) {
            move1.next = move2.next;
            move2.next = move1;
            move2 = move2.next.next;
            move1 = move1.next.next;
            ListNode temp = move2;
            move2 = move1;
            move1 = temp;
            move1.next = move2;
        }
        if (move2.next != null && move2.next.next != null) {
            ListNode tmp = move2.next;
            tmp.next = null;
            move2.next = move2.next.next;
            move2.next.next = tmp;
        }
        return head;
    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode second = head.next;
        ListNode third = second.next;

        second.next = head;
        head.next = swapPairs2(third);

        return second;
    }

    public static ListNode removeElements(ListNode head, int val) {
        if(head==null)return null;
        ListNode a = head;
        ListNode b = new ListNode(0);
        b.next = head;
        ListNode c=b;
        while (a != null) {
            if (a.val == val) {
                a = a.next;
                b.next = a;
            }else{
                a=a.next;
                b=b.next;
            }
        }
        return c.next;
    }

    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 1, 4};
        ListNodes a = new ListNodes();
//        System.out.println(a.subsetsWithDup(nums));
//        int[] nums2 = {-1, 0, 1, 2, -1, -4};
//        System.out.println(a.three_sum(nums2, 0));
//        System.out.println((int) '0' - 48);
//        System.out.println(numDecodings1("123"));
        int[] z = {1,3,2,4,5,6,4};
        ListNode head = buildListNode(z);
//        System.out.print(a.reverseBetween(head, 2, 4));
//        oddEvenList(head);
//        partition(head, 3);
        removeElements(head,4);
        ListNode p = new ListNode(0);
        p.next = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

}

