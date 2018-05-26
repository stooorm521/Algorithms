package priorityQueue;

import java.util.*;

public class Array {

    public int[] searchRange(int[] nums, int target) {

        int lo = 0, hi = nums.length, first = -1, last = -1;

        while (lo < hi) {

            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                first = mid;
                break;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        if (first != -1) {
            last = first;
            while (first > 0 && nums[first - 1] == target) first--;
            while (last < nums.length - 1 && nums[last + 1] == target) last++;
        }

        System.out.println(first + "," + last);
        return new int[]{first, last};
    }

    // number combinations
    int n=0;
    int[] nums;
    List<List<Integer>> result;

    public void find(List<Integer> values, int index, int reserve) {
        if (reserve == 0) {
            ArrayList<Integer> item = new ArrayList<>();
            item.addAll(values);
            result.add(item);
        }
        for (int i = index; i <=n; i++) {
            if (nums[i] <= reserve) {
                values.add(nums[i]);
                find(values, i, reserve - nums[i]);
                //为什么要remove
                values.remove(values.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int i = 1; i < candidates.length; i++) {
            if (candidates[i] != candidates[i - 1])
                candidates[++n] = candidates[i];
        }
        //去重 最后面多出来的没有管
        //记录下了最终的位置
        this.n = n;
        this.nums = candidates;
        this.result = new ArrayList<>();
        find(new ArrayList<>(), 0, target);
        return this.result;
    }


    //3SUM
    //4SUM
    //2SUM
    //Number Combinations for four II

    //可以重复选择
    //{}
    public List<List<Integer>> twoSum(int[] a, int target) {
        List<List<Integer>> rec = combinationSum(a, target);
        for (int i=0;i<rec.size();i++) {
            if (rec.get(i).size() != 4){
                rec.remove(rec.get(i));
                i--;
            }
        }
        return rec;
    }

    public static void main(String[] args) {
        Array a = new Array();
        int[] nums = {5, 2, 7, 8,12, 8, 8, 6, 1, 2, 9, 10};
//        System.out.println(a.searchRange(nums, 8).toString());
        int[] b = {2,3,6,7};
        System.out.println(a.combinationSum(nums, 13));
    }
}
