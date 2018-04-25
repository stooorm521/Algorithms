package Nqueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NSUM_problem {
    //for 2SuM; exactly 1 soulution
    public static int[] two_sum(int[] nums, int target) {
        HashMap<Integer, Integer> a = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            a.put(nums[i], i);
        }
        int[] b = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int record = target - nums[i];
            if (a.containsKey(record) && a.get(record) != i) {
                b[1] = (i);
                b[0] = (a.get(record));
                return b;
            }

        }
        return b;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] re = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == (nums[i] + nums[j])) {
                    re[0] = i;
                    re[1] = j;
                    return re;
                }
            }
        }
        return null;
    }

    public static List<List<Integer>> threeSumError(int[] num) {
        List<List<Integer>> rec = new ArrayList<>();
        HashMap<Integer, Integer> a = new HashMap();
        for (int i = 0; i < num.length; i++) {
            a.put(num[i], i);
        }
        for (int i = 0; i < num.length; i++) {
            for (int j = num.length - 1; j > i; j--) {
                int re = -(num[i] + num[j]);
                if (a.containsKey(re) && a.get(re) != i && a.get(re) != j) {
                    List<Integer> tmp = new ArrayList<>();
                    if (a.containsValue(i) && a.containsValue(j)) {
                        tmp.add(a.get(re));
                        a.remove(re);
                        tmp.add(j);
                        tmp.add(i);
                        rec.add(tmp);
                    }
                }

            }
        }
        return rec;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rec = new ArrayList<>();
        Arrays.sort(nums);
        for (int b = 0; b < nums.length - 2; b++) {
            int i = b + 1;
            int j = nums.length - 1;
            if (nums[b] == nums[i]) continue;
            while (i < j) {
                if (nums[i] + nums[b] + nums[j] == 0) {
                    List<Integer> m = new ArrayList<>();
                    m.add(nums[i]);
                    m.add(nums[j]);
                    m.add(nums[b]);
                    rec.add(m);
                    while (i < j && nums[i] == nums[i + 1]) i++;
                    while (i < j && nums[j] == nums[j - 1]) j--;
                    i++;
                    j--;
                } else {
                    if (nums[i] + nums[j] < 0) i++;
                    else j--;
                }
            }

        }
        return rec;
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closetSUM = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (Math.abs(nums[i] + nums[j] + nums[k] - target) < closetSUM) {
                    closetSUM = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    sum = nums[k] + nums[j] + nums[i];
                }
                if (nums[i] + nums[j] + nums[k] < target) j++;
                else k--;
            }
        }
        return sum;
    }

    public void rotate(int[] nums, int k) {
        k = k % (nums.length);
        allReverse(nums, 0, nums.length - 1);
        allReverse(nums, 0, k - 1);
        allReverse(nums, k, nums.length - 1);
    }

    public void allReverse(int[] z, int a, int b) {
        while (a < b) {
            int temp = z[a];
            z[a] = z[b];
            z[b] = temp;
            a++;
            b--;
        }
    }

    public static int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static int findLength(int[] a, int[] b) {
        int m = a.length, n = b.length;
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                max = Math.max(max, dp[i][j] = a[i] == b[j] ? 1 + dp[i + 1][j + 1] : 0);
        return max;
    }

    public void moveZeroes(int[] nums) {
        for (int fast = 0, slow = 0; fast < nums.length; fast++) {
            while (nums[fast] == 0 && nums[slow] != 0) {
                slow++;
            }
            if (nums[fast] == 0)continue;
            if (nums[slow] == 0) {
                swap(nums, fast, slow);
                slow++;
            }

        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
//        int[] nums={3,2,4};
//        int[] a=two_sum(nums,6);
//        int[] b=twoSum2(nums,6);
//        for(int i=0;i<a.length;i++){
//            System.out.print(a[i]+" ");
//        }
//        System.out.println();
//        for(int i=0;i<b.length;i++){
//            System.out.print(b[i]+" ");
        int[] z = {-1, 2, 1, 4};
        System.out.println(threeSumClosest(z, 1));
        NSUM_problem a = new NSUM_problem();
        int[] v = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        a.rotate(v, 5);
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }

        int[] m = {1, 1, 2, 3, 4, 1, 2, 3, 3, 5};
        minSubArrayLen(7, m);
        int[] A = {1, 2, 3, 2, 1, 6, 7, 8};
        int[] B = {3, 2, 1, 6, 1, 8, 4, 7};
        System.out.println(findLength(A, B));
        int[] k = {1,0,1};
        a.moveZeroes(k);
    }
}
