package Tree;

import java.util.*;

public class Tree {
    public static List<Integer> inorderTraversalforRecurrsive(TreeNode root) {
        List<Integer> a = new ArrayList<>();
        while (root != null) {
            inorderTraversalforRecurrsive(root.left);
            System.out.println(root.val);
            a.add(root.val);
            inorderTraversalforRecurrsive(root.right);
        }
        return a;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Queue<TreeNode> a = new LinkedList<>();
        List<Integer> rec = new ArrayList<>();
        while (root != null) {
            a.add(root);
            root = root.left;
        }
        return rec;

    }

    //构造树的两种方法
    public static TreeNode makeBinaryTreeByArray(int[] array, int index) {
        if (index < array.length) {
            int value = array[index];
            if (value != 0) {
                TreeNode t = new TreeNode(value);
                array[index] = 0;
                t.left = makeBinaryTreeByArray(array, index * 2);
                t.right = makeBinaryTreeByArray(array, index * 2 + 1);
                return t;
            }
        }
        return null;
    }

//    public static TreeNode sortedArrayToBST(int[] nums) {
//        TreeNode root = null;
//        root.val=nums[0];
//        Queue<Integer> queue=new LinkedList<Integer>();
//        for(int i=1;i<nums.length;i++) queue.offer(nums[i]);
//        while(!queue.isEmpty()){
//        	root.left=new TreeNode(queue.poll());
//        	root.right=new TreeNode(queue.poll());
//        }
//        return root;
//    }

    public static void depthOrderTraversal(TreeNode root) {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (stack.isEmpty() == false) {
            //此处的pop因为就一个[root]节点，所以会全部pop出去
            TreeNode node = stack.pop();
            //这里是操作行
            System.out.print(node.val + " ");
            //这里先右边后左边的原因是等会儿pop出去取值的时候，会变为先左后右右
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.print("\n");
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper1(res, list, root, sum);
        return res;
    }

    private static void helper1(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<>(list));
        }
        helper1(res, list, root.left, sum - root.val);
        helper1(res, list, root.right, sum - root.val);
        list.remove(list.size() - 1);
    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<String>();
        if(root == null) return rst;
        StringBuilder sb = new StringBuilder();
        helper(rst, sb, root);
        //这里运用一个helper
        return rst;
    }

    public void helper(List<String> rst, StringBuilder sb, TreeNode root){
        if(root == null) return;
        int tmp = sb.length();
        if(root.left == null && root.right == null){
            //已经到达叶节点
            sb.append(root.val);
            //加入最终的结果
            rst.add(sb.toString());
            //加完了以后就删除？
            sb.delete(tmp , sb.length());
            return;
        }
        sb.append(root.val + "->");
        helper(rst, sb, root.left);
        helper(rst, sb, root.right);
        sb.delete(tmp , sb.length());
        return;

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[] arr = {5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 5, 1};
        TreeNode root = makeBinaryTreeByArray(array, 0);
//        inorderTraversalforRecurrsive(root);
        Tree a =new Tree();
        a.binaryTreePaths(root);
    }
}
