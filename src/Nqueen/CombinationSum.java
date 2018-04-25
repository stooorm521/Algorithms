package Nqueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rec = new ArrayList<>();
        List<Integer> rec1 = new ArrayList<>();
        int b = 0;
        Arrays.sort(candidates);
        List<Integer> a = new Vector<>();
        for (int i = 0; i < candidates.length; i++) {
            if (!a.contains(candidates[i]))
                a.add(candidates[i]);
        }
        //这里把 candicates 写成了list形式
        help(rec, rec1, b, a, target);
        return rec;
    }

    public void help(List<List<Integer>> rec, List<Integer> rec1, int start, List<Integer> candicates, int target) {
        if (target < 0) return;
        if (target == 0) {
            rec.add(rec1);
            return;
        }
        for (int i = start; i < candicates.size(); i++) {
            rec1.add(candicates.get(i));
            help(rec,rec1,start,candicates,target-candicates.get(i));
            rec1.clear();
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 3, 6, 7};
        CombinationSum b = new CombinationSum();
        System.out.println(b.combinationSum(a, 7));
    }
}
