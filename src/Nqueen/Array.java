package Nqueen;

import com.sun.tools.corba.se.idl.InterfaceGen;
import com.sun.tools.corba.se.idl.constExpr.ShiftLeft;

import java.util.*;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class Array {
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) return result;
//sorrt the interval list at the start.
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            //自己重写sort方法
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        ;
        Interval tmp = intervals.get(0);
        if (intervals.size() == 1) {
            result.add(tmp);
            return result;
        }
        for (int i = 0; i < intervals.size(); i++) {
            if (tmp.end >= intervals.get(i).start) {
                tmp.end = Math.max(tmp.end, intervals.get(i).end);
            } else {
                result.add(tmp);
                tmp = intervals.get(i);
            }
        }
        result.add(tmp);
        return result;
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0 || n == 1) return;
        for (int i = 0; i < n / 2; i++) {
            int[] tmp = matrix[n - 1 - i];
            matrix[n - 1 - i] = matrix[i];
            matrix[i] = tmp;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

    public int[] searchRange(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length / 2;
        helpSearchRange(nums, target, n, list);
        return new int[7];
    }

    public void helpSearchRange(int[] nums, int target, int n, List<Integer> list) {
        if (n < 0 || n >= nums.length) return;
        if (target < nums[n]) helpSearchRange(nums, target, n / 2, list);
        else if (target > nums[n]) helpSearchRange(nums, target, (n + target) / 2, list);
        else if (target == nums[n]) {
            list.add(n);
            helpSearchRange(nums, target, n / 2, list);
            helpSearchRange(nums, target, (n + target) / 2, list);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
        int z = m + n - 1;
        int j = n - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (j >= 0) {
                if (nums2[j] >= nums1[i]) {
                    nums1[z] = nums2[j];
                    z--;
                    j--;
                    i++;
                } else {
                    nums1[z] = nums1[i];
                    z--;
                }
            }
        }
        while (j >= 0) {
            nums1[j] = nums2[j];
            j--;
        }
        for (int i = 0; i < m + n; i++) {
            System.out.print(nums1[i] + " ");
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        List<Integer> c = new ArrayList<>();
        c.add(1);
        result.add(c);
        for (int i = 1; i < numRows; i++) {
            List<Integer> a = new ArrayList<>();
            List<Integer> tmp = result.get(result.size() - 1);
            a.add(1);
            for (int j = 0; j < tmp.size() - 1; j++) {
                a.add(tmp.get(j) + tmp.get(j + 1));
            }
            a.add(1);
            result.add(a);
        }
        return result;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> c1 = new ArrayList<>();
        if (rowIndex == 0) {
            c1.add(1);
            return c1;
        }
        List<Integer> c = getRow(rowIndex - 1);
        c1.add(1);
        for (int i = 0; i < c.size() - 1; i++) {
            c1.add(c.get(i) + c.get(i + 1));
        }
        c1.add(1);
        return c1;
    }

    public static void sortColors(int[] nums) {
        int j = nums.length - 1;
        int tmp = -1;
        for (int i = 0; i < nums.length - 1; ) {
            for (j = nums.length - 1; j >= 0; ) {
                if (nums[j] > nums[i]) {
                    if (nums[i + 1] < nums[i]) {
                        tmp = nums[i + 1];
                        nums[i + 1] = nums[i];
                        nums[i] = tmp;
                    }
                    i++;
                } else {
                    tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    if (nums[j] == 2) {
                        j--;
                        i++;
                    } else i++;
                }
            }
        }
    }

    public static void sortColors2(int[] nums) {
        int i = -1;
        int j = -1;
        int k = -1;
        for (int p = 0; p < nums.length; p++) {
            //根据第i个数字，挪动0~i-1串。
            if (nums[p] == 0) {
                nums[++k] = 2;    //2往后挪
                nums[++j] = 1;    //1往后挪
                nums[++i] = 0;    //0往后挪
            } else if (nums[p] == 1) {
                nums[++k] = 2;
                nums[++j] = 1;
            } else
                nums[++k] = 2;
        }

    }

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//    }

    public static int searchinRotatedSortArray(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                if (nums[mid] < target && nums[right] <= target) left = mid + 1;
                else right = mid - 1;
            } else {
                if (nums[mid] > target && nums[left] >= target) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Interval> a = new ArrayList<>();
        a.add(new Interval(1, 4));
        a.add(new Interval(4, 5));
//        System.out.println(merge(a));
        int[][] mateix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        rotate(mateix);
//        int[] b={1,2,3,4,5,6,7,8,9,9,9,9,9,10};
//        Array a1= new Array();
//        a1.searchRange(b,9);
//        int m = Integer.MIN_VALUE;
//        int[] a1 = {4, 5, 6, m, m, m, m, m, m, m, m, m, m, m, m, m, m, m};
//        int[] a2 = {1, 2, 3};
//        merge(a1, 3, a2, 3);
//        System.out.println(generate(19));
//        System.out.println(getRow(0));
        int[] num = {4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(searchinRotatedSortArray(num, 8));
        int[] nums = {0, 2, 1, 0, 1, 2, 2, 1, 2, 0};
        sortColors2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
