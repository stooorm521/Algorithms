package Tree;

import java.util.*;

public class Tree {
    public static List<Integer> inorderTraversalforRecurrsive(TreeNode root) {
        List<Integer> a=new ArrayList<>();
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
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = makeBinaryTreeByArray(array,1);
        inorderTraversalforRecurrsive(root);
    }
}
