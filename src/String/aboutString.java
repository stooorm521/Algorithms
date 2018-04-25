package String;

import java.util.*;

public class aboutString {

    public static List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> a = new HashMap<>();
        List<String> rec = new ArrayList<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            if (!a.containsKey(s.substring(i, i + 10))) {
                a.put(s.substring(i, i + 10), i);
            } else {
                if (!rec.contains(s.substring(i, i + 10)))
                    rec.add(s.substring(i, i + 10));
            }
        }
        return rec;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        List<Character> a = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            a.add(s.charAt(i));
        }
        int j;
        for (j = 0; j < t.length(); j++) {
            if (a.contains(t.charAt(j)))
                continue;
            else return false;
        }
        if (j == t.length()) return true;
        else return false;
    }

    public static boolean isAnagram2(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static int countPrimes(int n) {
        boolean[] a = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!a[i])
                count++;
            for (int j = 2; i * j < n; j++) {
                a[i * j] = true;
            }
        }
        return count;
    }

    public boolean isPrimeNumber(int num) {
        if (num == 2) return true;//2特殊处理
        if (num < 2 || num % 2 == 0) return false;//识别小于2的数和偶数
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {//识别被奇数整除
                return false;
            }
        }
        return true;
    }

    public boolean isUgly(int num) {
        if (num == 0) return false;
        if (num == 1) return true;
        if (num % 5 == 0) {
            return isUgly(num / 5);
        } else if (num % 3 == 0) {
            return isUgly(num / 3);
        } else if (num % 2 == 0) {
            return isUgly(num / 2);
        } else {
            return false;
        }
    }

    //龟兔赛跑
    public int nthUglyNumber(int n) {
        int[] uglyNum = new int[n]; // 用于存放前n个丑数
        uglyNum[0] = 1;

        int factor2 = 2, factor3 = 3, factor5 = 5;
        int index2, index3, index5;
        index2 = index3 = index5 = 0;

        for (int i = 1; i < n; ++i) {
            // 取三组中的最小
            int minNum = min(factor2, factor3, factor5);
            uglyNum[i] = minNum;

            // 分三组计算
            if (factor2 == minNum)
                factor2 = 2 * uglyNum[++index2];
            if (factor3 == minNum)
                factor3 = 3 * uglyNum[++index3];
            if (factor5 == minNum)
                factor5 = 5 * uglyNum[++index5];
        }
        int temp = uglyNum[n - 1];
        return temp;
    }

    private int min(int a, int b, int c) {
        // 求三个数的最小值
        int minNum = a > b ? b : a;
        return minNum > c ? c : minNum;
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> a = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!a.containsKey(s.charAt(i))) {
                if (!a.containsValue(t.charAt(i))) {
                    a.put(s.charAt(i), t.charAt(i));
                } else {
                    return false;
                }
            } else {
                if (a.get(s.charAt(i)) == t.charAt(i)) continue;
                return false;
            }
        }
        return true;

    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) return false;
        HashMap<Integer, Integer> a = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!a.containsKey(nums[i])) {
                a.put(nums[i], 1);
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) return false;
        HashMap<Integer, Integer> a = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!a.containsKey(nums[i])) {
                a.put(nums[i], i);
            } else {
                if (i - a.get(nums[i]) <= k) return true;
                else {
                    a.remove(nums[i]);
                    a.put(nums[i], i);
                }
            }


        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) return false;
        TreeSet<Integer> a = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            if ((a.floor(tmp) != null && tmp <= a.floor(tmp) + t) || (a.ceiling(tmp) != null && tmp >= a.ceiling(tmp) - t))
                return true;

            a.add(tmp);
            if (i >= k)
                a.remove(nums[i - k]);

        }
        return false;
    }

    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        if (citations.length == 1 && citations[0] == 0) return 0;
        if (citations.length == 1 && citations[0] != 0) return 1;
        Arrays.sort(citations);
        HashMap<Integer, Integer[]> a = new HashMap<>();
        for (int i = 0, j = citations.length; i < citations.length; i++) {
            int count = 1;
            while (i < citations.length - 1 && citations[i] == citations[i + 1]) {
                count++;
                i++;
            }
            if (i == citations.length - 1 && citations[i] == citations[i - 1]) {
                count++;
            }
            if (!a.containsKey(citations[i])) {
                Integer[] tmp = new Integer[2];
                tmp[0] = j;
                tmp[1] = i + 1;
                a.put(citations[i], tmp);
            }
            j = j - (count);
        }
        int max = 0;
        for (int i = 1; i < citations.length; i++) {
            if (a.get(citations[i])[0] == a.get(citations[i])[1] && citations[i] == a.get(citations[i])[0])
                max = Math.max(max, citations[i]);
        }
        return max;
    }

    public int hIndex2(int[] citations) {
        int length = citations.length;
        if (length == 0) {
            return 0;
        }

        int[] array2 = new int[length + 1];
        for (int i = 0; i < length; i++) {
            if (citations[i] > length) {
                array2[length] += 1;
            } else {
                array2[citations[i]] += 1;
            }
        }
        int t = 0;
        int result = 0;

        for (int i = length; i >= 0; i--) {
            t = t + array2[i];
            if (t >= i) {
                return i;
            }
        }
        return 0;
    }

    public static boolean wordPattern(String pattern, String str) {
        //pattern, str
        HashMap<Character, String> a = new HashMap();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') count++;
        }
        if (count != pattern.length() - 1) return false;
        for (int i = 0, j = 0, k = 0; i < str.length(); ) {
            while (i < str.length() && str.charAt(i) != ' ') {
                i++;
            }
            if (!a.containsKey(pattern.charAt(k))) {
                if (!a.containsValue(str.substring(j, i))) {
                    a.put(pattern.charAt(k), str.substring(j, i));
                    i++;
                    j = i;
                    k++;
                } else
                    return false;
            } else {
                if (!a.get(pattern.charAt(k)).equals(str.substring(j, i))) {
                    return false;
                } else {
                    i++;
                    j = i;
                    k++;
                }
            }
        }

        return true;

    }


    public static List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        //key: nums[i], value: count
        HashMap<Integer, Integer> a = new HashMap();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ) {
            if (!a.containsKey(nums[i])) {
                a.put(nums[i], 1);
            } else {
                a.put(nums[i], a.get(nums[i]) + 1);
            }
            i++;
        }
        List<Integer> b = new ArrayList<>(a.values());
        Collections.sort(b);
        List<Integer> c = new ArrayList<>();
        int i = b.size() - 1;
//        while (k >= 0 && i >= 0) {
//            if (!c.contains(b.get(i))) {
//                c.add(b.get(i));
//                k--;
//                i--;
//            } else {
//                i--;
//
//        }
//        int j = 0;
//        while (j < c.size()) {
//            result.add(getKey(a, c.get(j)));
//            j++;
//        }
//        for(Map.Entry entry:a.entrySet()){
//
//        }
        return result;
    }

    public static List<Integer> topKFrequent2(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    public static int findKthLargest(int[] nums, int k) {
//        List<Integer>[] bucket = new List[nums.length+1];
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i : nums) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//        for(int key:map.keySet()){
//            int frequency=map.get(key);
//            //只有为空的时候才add 一个list;
//            if(bucket[frequency]==null)
//                bucket[frequency]=new ArrayList<>();
//            bucket[frequency].add(key);
//        }
//
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        if (nums.length == k) return nums[0];
        k--;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (k == 0) return nums[i];
            k--;
        }
        return 0;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i : nums1) {
            if (!a.contains(i)) a.add(i);
        }
        for (int j : nums2) {
            if (a.contains(j) && !b.contains(j)) b.add(j);
        }
        int[] c = new int[b.size()];
        for (int i = 0; i < c.length; i++) {
            c[i] = b.get(i);
        }
        return c;
    }

    private static Integer getKey(Map<Integer, Integer> map, Integer value) {
        Integer key = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                key = entry.getKey();
            }
        }
        return key;
    }

    public int intersect(int[] nums1, int[] nums2) {
        Set<Integer[][]> a = new HashSet<>();
        for(int i:nums1)
            a.add(new Integer[2][3]);
return 0;

    }

    public static void main(String[] args) {
//        String s = "AAAAAAAAAAAA";
//        System.out.println(findRepeatedDnaSequences(s));
//        String a = "aacc";
//        String b = "ccac";
//        System.out.println(isAnagram2(a, b));
//        String[] c = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        System.out.println(groupAnagrams(c));
//        aboutString m = new aboutString();
////        System.out.println(m.countPrimes(499979));
//        m.nthUglyNumber(123);
//        int[] a = {1, 2, 3, 4, 5, 1, 6, 8, 9, 1};
//        System.out.println(containsDuplicate(a));
//        System.out.println(containsNearbyDuplicate(a, 3));
//        int[] citations = {0, 1};
//        System.out.println(hIndex(citations));
//        String pattern = "abba";
//        String str = "dog cat fish dog";
//        System.out.println(wordPattern(pattern, str));

        int[] a = {1, 2, 3, 3, 3, 3, 2, 2, 7, 7, 7, 7, 9, 9, 9, 9};
        int[] b = {2, 5, 7, 9, 7, 10, 13, 9, 17};
        System.out.println(intersection(a, b));
    }
}
