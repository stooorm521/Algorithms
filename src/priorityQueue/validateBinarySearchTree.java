package priorityQueue;

import Nqueen.Array;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }
}

public class validateBinarySearchTree {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return 0;
        int a = root.val;
        Set<Integer> set = new HashSet<>();
        find(root, set);
        Integer[] arr = (Integer[]) set.toArray(new Integer[0]);
        for (Integer itg : arr) {
            if (itg > a) {
                return itg;
            }
        }
        return -1;
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        Set<Integer> set = new HashSet<>();
        find(root, set);
        Integer[] arr = set.toArray(new Integer[0]);
        return arr[k - 1];
    }

    public void find(TreeNode node, Set<Integer> set) {
        if (node != null) {
            if (!set.contains(node.val)) set.add(node.val);
            find(node.left, set);
            find(node.right, set);
        }
    }

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        findmode(root, map);
        ArrayList<Integer> re = new ArrayList<Integer>();
        List fc = new ArrayList();
        List help = new ArrayList();
        int i = 0;
        //保持map有序
//        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
//        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
////            //升序排序
////            public int compare(Entry<String, String> o1,
////                               Entry<String, String> o2) {
////                return o1.getValue().compareTo(o2.getValue());
////            }
//
//        });
//        List<Integer,Integer> a

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            help.add(entry.getValue());
            fc.add(entry.getKey());
            if (i >= 1) {
                if (help.get(i - 1) == entry.getValue()) {
                    re.add(entry.getKey());
                } else {
                    break;
                }
            }
            i++;
        }
        re.add((Integer) fc.get(0));
        int[] c = new int[re.size()];
        for (int m = 0; m < c.length; m++) {
            c[m] = re.get(m);
            System.out.println(c[m]);
        }
        return c;
    }


    private void findmode(TreeNode node, HashMap<Integer, Integer> map) {
        if (node != null) {
            if (!map.containsKey(node.val)) map.put(node.val, 1);
            else {
                map.put(node.val, map.get(node.val) + 1);
            }
            findmode(node.left, map);
            findmode(node.right, map);
        }
    }

    static void preOderTraverse(TreeNode root, List<Integer> a) {
        if (root != null) {
            preOderTraverse(root.left, a);
            preOderTraverse(root.right, a);
            a.add(root.val);
        }
    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

    //找到二叉搜索树的第k个最小的值其实用到的就是中序遍历
    public int kthsmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) break;
            root = root.right;
        }
        return root.val;
    }


    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //有效的二叉树中当然不能有等于
            if(pre != null && root.val <= pre.val) return false;
            //记录一下前驱
            pre = root;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode a0 = new TreeNode(5);
        a0.left = new TreeNode(1);
        a0.right = new TreeNode(6);
        a0.left.left = new TreeNode(0);
        a0.left.right = new TreeNode(3);
        a0.right.left = new TreeNode(4);
        a0.right.right = new TreeNode(9);
        validateBinarySearchTree a = new validateBinarySearchTree();
//        a.findMode(a0);
//        preOderTraverse(a0,new ArrayList<>());
        System.out.println(a.isValidBST(a0));

    }
}
