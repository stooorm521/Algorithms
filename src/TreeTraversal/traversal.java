package TreeTraversal;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class traversal {

    //之前的递归方式的pre order/ in order / left order 的 review;
    //着三种不同的方式巧就巧的print出现的时机
//    public void theFirstTraversal(Node root) {  //先序遍历
//        printNode(root);
//        if (root.getLeftNode() != null) {  //使用递归进行遍历左孩子
//            theFirstTraversal(root.getLeftNode());
//        }
//        if (root.getRightNode() != null) {  //递归遍历右孩子
//            theFirstTraversal(root.getRightNode());
//        }
//    }


//    public void theInOrderTraversal(Node root) {  //中序遍历
//        if (root.getLeftNode() != null) {
//            theInOrderTraversal(root.getLeftNode());
//        }
//        printNode(root);
//        if (root.getRightNode() != null) {
//            theInOrderTraversal(root.getRightNode());
//        }
//    }
//

//
//    public void thePostOrderTraversal(Node root) {  //后序遍历
//        if (root.getLeftNode() != null) {
//            thePostOrderTraversal(root.getLeftNode());
//        }
//        if(root.getRightNode() != null) {
//            thePostOrderTraversal(root.getRightNode());
//        }
//        printNode(root);
//    }
//

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> a = new Stack<>();
        TreeNode node = root;
        List<Integer> rec = new LinkedList<>();
        while (node != null || a.size() > 0) {
            if (node != null) {
                a.push(node);
                node = node.left;
            } else {
                node = a.pop();
                rec.add(node.val);
                node = node.right;
            }
        }
        return rec;
    }

//不许看答案的背下来

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        TreeNode move = root;
        while (move != null || !stack.isEmpty()) {
            if (move != null) {
                result.add(move.val);
                stack.push(move);
                move = move.left;
            } else {
                move = stack.pop();
                move = move.right;
            }
        }
        return result;
    }

    //逆序有点难
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        TreeNode move = root;
        Stack<TreeNode> a = new Stack<>();
        Stack<TreeNode> backup = new Stack<>();
        while (move != null || !a.isEmpty()) {
            if (move != null) {
                a.push(move);
                backup.push(move);
                move = move.right;
            } else {
                move = a.pop();
                move = move.left;
            }

            while (!backup.isEmpty()) {
                result.add(backup.pop().val);
            }
        }
        Collections.reverse(result);
        return result;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode fakeHead = head;
        ListNode a = head.next;
        fakeHead.next = null;
        while (a.next != null) {
            ListNode backup = a.next;
            a.next = fakeHead;
            fakeHead = a;
            a = backup;
        }
        a.next = fakeHead;
        return a;
    }

    private static ListNode buildListNode2(int[] a) {

        ListNode first = null, last = null, newNode;
        int num;
        if (a.length > 0) {
            for (int i = 0; i < a.length; i++) {
                newNode = new ListNode(a[i]);
                newNode.next = null;
                if (first == null) {
                    first = newNode;
                    last = newNode;
                } else {
                    last.next = newNode;
//                    System.out.println(last.val);
                    last = newNode;
//                    System.out.println(last.val);
                }
            }
        }
        return first;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(postorderTraversal(root));
        int[] c = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode v = buildListNode2(c);
        ListNode m=reverseList(v);
        while (m != null) {
            System.out.print(m.val + " ");
            m = m.next;
        }
    }
}
