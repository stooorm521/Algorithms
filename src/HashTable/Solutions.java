package HashTable;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class Solutions {
    public static String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) return "0";
        if (denominator == 0) return "";
        String ans = "";
        if (numerator < 0 ^ denominator < 0) ans += '-';//异或，numerator<0和denominator<0仅有一个为真
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        //结果的整数部分
        long res = num / den;
        ans += String.valueOf(res);
        //如果能够整除，返回结果
        long rem = (num % den) * 10;
        if (rem == 0) return ans;
        //结果的小数部分
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        ans += ".";
        while (rem != 0) {
            //如果前面已经出现过该余数，那么将会开始循环
            if (map.containsKey(rem)) {
                int beg = map.get(rem); //循环体开始的位置
                String part1 = ans.substring(0, beg);
                String part2 = ans.substring(beg, ans.length());
                ans = part1 + "(" + part2 + ")";
                return ans;
            }

            //继续往下除
            map.put(rem, ans.length());
            res = rem / den;
            ans += String.valueOf(res);
            rem = (rem % den) * 10;
        }

        return ans;
    }

    public static int lengthOfLongestSubstring(String s) {
//damdawadajfel
        int result = 0;
        if (s == "") return result;
        for (int i = 0; i < s.length(); ) {
            HashSet<Character> a = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (a.contains(s.charAt(j))) {
                    result = Math.max(result, j - i);
                    break;
                } else if (j == s.length() - 1) {
                    result = Math.max(result, j - i + 1);
                } else {
                    a.add(s.charAt(j));
                }
            }

            i++;
        }
        return result;
    }

    public static void main(String[] args) {
//            System.out.println(fractionToDecimal(111, 7));
        String s = "c";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
