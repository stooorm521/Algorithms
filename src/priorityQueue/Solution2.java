package priorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    Integer prev = null;
    int count = 1;
    int max = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        List<Integer> list = new ArrayList<>();
        traverse(root, list);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
        return res;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        if (prev != null) {
            if (root.val == prev)
                count++;
            else
                count = 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right, list);
    }

    public int numTrees(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[n];
    }


    public ArrayList<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return helper(1, n);
    }

    public ArrayList<TreeNode> helper(int left, int right) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i < right; i++) {
            ArrayList<TreeNode> leftList = helper(left, i - 1);
            ArrayList<TreeNode> rightList = helper(i + 1, right);
            for (int j = 0; j < leftList.size(); j++) {
                for (int k = 0; k < rightList.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(j);
                    root.right = rightList.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> rec = new Stack<>();
        for (String a : tokens) {
            if (!(a.equals("+") | a.equals("-") | a.equals("*") | a.equals("/"))) {
                rec.push(Integer.parseInt(a));
            } else if (a.equals("+")) {
                rec.push(rec.pop() + rec.pop());
            } else if (a.equals("-")) {
                rec.push(-(rec.pop() - rec.pop()));
            } else if (a.equals("*")) {
                rec.push(rec.pop() * rec.pop());
            } else if (a.equals("/")) {
                int count = rec.size();
                if (rec.get(count - 2) != null) {
                    if (rec.get(count - 2) == 0) {
                        rec.pop();
                    } else {
                        Integer tmp = rec.get(count - 2) / rec.pop();
                        rec.pop();
                        rec.push(tmp);
                    }
                }
            }
        }
        return rec.pop();
    }

    public String reverseString(String s) {
        return new StringBuffer().append(new StringBuffer(s).reverse()).toString();
    }

    public static void main(String[] args) {
        TreeNode a0 = new TreeNode(3);
        a0.left = new TreeNode(3);
        a0.right = new TreeNode(2);
        a0.left.left = new TreeNode(2);
        a0.left.right = new TreeNode(3);
        a0.right.left = new TreeNode(2);
        a0.right.right = new TreeNode(9);
        Solution2 a = new Solution2();
//        a.findMode(a0);
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        String[] tokens2 = {"2", "1", "+", "3", "*"};
        String[] tokens3 = {"4", "13", "5", "/", "+"};
        String cas="Hello I want you";
        System.out.println(a.reverseString(cas));
    }
}
