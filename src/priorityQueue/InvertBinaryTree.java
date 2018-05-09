package priorityQueue;

import java.util.*;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode rec = new TreeNode(0);
        Traversesal(root, rec);
        return rec;
    }

    void Traversesal(TreeNode root, TreeNode rec) {
        if (root != null) {
            rec.val = root.val;
            if (root.left != null)
                Traversesal(root.left, rec.right = new TreeNode(0));
            if (root.right != null)
                Traversesal(root.right, rec.left = new TreeNode(0));
        }
    }

    private String serialize(TreeNode node, Map<String, List<TreeNode>> map) {

        if (node == null) return "";
        String s = "<" + serialize(node.left, map) + node.val + serialize(node.right, map) + ">";
        if (!map.containsKey(s)) map.put(s, new ArrayList<>());
        map.get(s).add(node);
        return s;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) return result;
//        将每一个节点的左子节点的值和右结点的值都存储下来，组成一个字符串，作为索引，将对应节点保存到map里。
        Map<String, List<TreeNode>> map = new HashMap<>();
        serialize(root, map);

        for (List<TreeNode> rootGroup : map.values()) {
            if (rootGroup.size() > 1) result.add(rootGroup.get(0));
        }
        return result;
    }

    public String tree2str(TreeNode t) {
        String s="";
        return tra(t, s);
    }

    String tra(TreeNode root,String s) {
        if (root != null) {
            //这里放前面preorder为什么不行，而中序以及后序为什么行，原因未知
            s='('+root.val+tra(root.left,s)+tra(root.right,s)+')';
        }
        return s;
    }

    public String tree2str2(TreeNode t) {
        if(t == null)
            return "";
        String l = tree2str2(t.left);
        String r = tree2str2(t.right);
        if(l.equals("") && r.equals("")){
            System.out.println(t.val + "");
            return t.val + "";}
        else if(r.equals("")){
            System.out.println(t.val + "(" + l + ")");
            return t.val + "(" + l + ")";}
            System.out.println(t.val + "(" + l + ")" + "(" + r + ")");
        return t.val + "(" + l + ")" + "(" + r + ")";

    }
    public static void main(String[] args) {
        TreeNode a0 = new TreeNode(4);
        a0.left = new TreeNode(2);
        a0.right = new TreeNode(7);
        a0.left.left = new TreeNode(1);
        a0.left.right = new TreeNode(3);
        a0.right.left = new TreeNode(6);
        a0.right.right = new TreeNode(9);
        InvertBinaryTree a = new InvertBinaryTree();

        System.out.println(a.tree2str2(a0));

    }
}
