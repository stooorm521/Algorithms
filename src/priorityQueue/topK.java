package priorityQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * 已知几个递减有序的m个数组，求这几个数据前k大的数
 * a[4,3,2,1],b[6,5,3,1] -> result[6,5,4]
 * <p>
 * 这里的描述很清晰了 直观方法
 * 实现描述：采用Merge的方法，设定一个数组下标扫描位置记录临时数组和top结果数组，然后从临时数组记录下标开始遍历所有数组并比较大小
 * 将最大值存入结果数组，最大值对应所在数组下标加一存入临时数组，以使其从下位开始遍历，时间复杂度为O(k*m)。(m:为数组的个数）。
 */
public class topK {
    public static int[] getTopK(List<List<Integer>> input, int k) {
        int index[] = new int[input.size()];//保存每个数组下标扫描的位置;
        int result[] = new int[k];
        for (int i = 0; i < k; i++) {
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            for (int j = 0; j < input.size(); j++) {
                if (index[j] < input.get(j).size()) {
                    if (max < input.get(j).get(index[j])) {
                        max = input.get(j).get(index[j]);
                        maxIndex = j;
                    }
                }
            }
            if (max == Integer.MIN_VALUE) {
                return result;
            }
            result[i] = max;
            index[maxIndex] += 1;

        }
        return result;
    }


    /**
     * 利用快速排序的过程来求最小的k个数
     *
     */
    public int partion(int a[], int first, int end) {
        int i = first;
        int main = a[end];
        for (int j = first; j < end; j++) {
            if (a[j] < main) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                i++;
            }
        }
        a[end] = a[i];
        a[i] = main;
        return i;
    }

    void getTopKMinBySort(int a[], int first, int end, int k) {
        if (first < end) {
            int partionIndex = partion(a, first, end);
            if (partionIndex == k - 1) return;
            else if (partionIndex > k - 1) getTopKMinBySort(a, first, partionIndex - 1, k);
            else getTopKMinBySort(a, partionIndex + 1, end, k);
        }
    }



    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        a.add(4);
        a.add(3);
        a.add(2);
        a.add(1);
        List<Integer> b = new ArrayList<Integer>();
        b.add(6);
        b.add(5);
        b.add(3);
        b.add(1);
        List<List<Integer>> ab = new ArrayList<List<Integer>>();
        ab.add(a);
        ab.add(b);
        int r[] = getTopK(ab, 3);
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }

        //for 2
        int a2[] = {2, 20, 3, 7, 9, 1, 17, 18, 0, 4};
        int k = 6;
        new topK().getTopKMinBySort(a2, 0, a2.length - 1, k);
        for (int i = 0; i < k; i++) {
            System.out.print(a2[i] + " ");
        }
    }
}