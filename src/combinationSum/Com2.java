package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Com2 {
    //第二次要求的是不可重复的
    int n = 0;
    int[] nums;
    List<List<Integer>> result;

    public void find(List<Integer> values, int index, int reserve) {
        if (reserve == 0) {
            ArrayList<Integer> item = new ArrayList<>();
            item.addAll(values);
            result.add(item);
        }
        for (int i = index; i <= n; i++) {
            if (nums[i] <= reserve) {
                values.add(nums[i]);
                find(values, i, reserve - nums[i]);
                //为什么要remove
                values.remove(values.size() - 1);
            }
        }
    }


    List<List<Integer>> result2;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.n = n;
        this.nums = candidates;
        this.result = new ArrayList<>();
        find(new ArrayList<>(), 0, target);
        return this.result;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> rec = new ArrayList<>();
        List<Integer> nums1 = Arrays.stream(nums).boxed().collect(Collectors.toList());
        help(result2, rec, nums1);
        return result2;
    }

    public void help(List<List<Integer>> result2, List<Integer> rec, List<Integer> nums1) {
        if (nums1.size() == 0) result2.add(rec);
        rec.add(nums1.get(nums1.size()-1));
        nums1.remove(nums1.size()-1);
        help(result2,rec, nums1);
    }


    public static void main(String[] args) {
        Com2 a = new Com2();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
//        System.out.println(a.searchRange(nums, 8).toString());
        int[] b = {2, 3, 6, 7};
        int[] c={1,2,3};
        System.out.println(a.permute(c));
    }
}
