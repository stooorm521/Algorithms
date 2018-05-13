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


    int n;
    int[] nums;
    List<List<Integer>> result;
    public void find(List<Integer> values, int index, int reserve){
        if(reserve==0){

        }
    }

    public static void main(String[] args) {
        Array a = new Array();
        int[] nums = {5, 7, 7, 8, 8, 8, 8, 8, 8, 8, 9, 10};
        System.out.println(a.searchRange(nums, 8).toString());
    }
}
