package Nqueen;

public class DPproblem {
    //198.Leetcode
    public static int rob(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int[] record=new int[nums.length];
        record[0]=nums[0];
        record[1]=nums[1];
        for (int i = 2; i < nums.length; i++) {
            //last one get or not get
            record[i] = Math.max(nums[i]+record[i-2], record[i - 1]);
        }
        return record[nums.length-1];
    }
public static int rob2(int[] nums){
        int ifrobedprevious=0;
        int ifnotrobedprevious=0;
        for(int i=0;i<nums.length;i++){


            //1.current robbed
            int currobbed=ifnotrobedprevious+nums[i];
            //2.current not robbed
            int curnotrobed=Math.max(ifnotrobedprevious,ifrobedprevious);

            ifrobedprevious=currobbed;
            ifnotrobedprevious=curnotrobed;

        }
        return Math.max(ifnotrobedprevious,ifrobedprevious);
}
    public static void main(String[] args) {
        int[] a={1,2,4,3,5,6,3,2};
        System.out.println(rob2(a));
    }

}
