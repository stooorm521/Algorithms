package Tree;

import java.util.HashSet;
import java.util.Set;

public class Others {
    //指的是2的power，不是任意两个数的power
    public boolean isPowerOfTwo(int n) {
        Set<Integer> a = new HashSet<>();
        int sum = 1;
        while (sum < Integer.MAX_VALUE&&sum>0) {
            a.add(sum);
            sum *= 3;
        }
        if (a.contains(n)) return true;
        else
            return false;

    }

    public static void main(String[] args) {
        Others a=new Others();
        System.out.println(a.isPowerOfTwo(2411241));
    }
}
