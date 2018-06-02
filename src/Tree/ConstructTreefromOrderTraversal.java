package Tree;

public class ConstructTreefromOrderTraversal {
    //1. 从中序遍历和前序遍历得到的数组建立二叉树
    TreeNode Costruct(int[] preorder, int[] inorder, int length) {
        if (preorder.length == 0 || inorder.length == 0 || length == 0) return null;
        return ConstructCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode ConstructCore(int[] preorder, int startPreorder, int endPreorder, int[] Inorder, int startInorder, int endInorder) {
        //递归停止的条件
        if (startPreorder > endPreorder || startInorder > endInorder) return null;
        //前序遍历的第一个值是跟节点的值
        TreeNode root = new TreeNode(preorder[startPreorder]);
        int flag = 0;
        for (int i = startInorder; i < endInorder; i++) {
            if (preorder[startInorder] == Inorder[i]) {
                flag = i;
                break;
            }
        }

        // flag-startInorder, 万一 right.Inorder是从中点开始计算的inorder的， 则需要 减去上一节的startInorder
        //为什么preEnd=startPre+(flag-startIn)? 因为在中序遍历中，根节点左边的n个值就是一定是属于左子树的，那么在前序遍历中，
        //preStart+n就是拿到了前序遍历左子树的最后一个值，+1则会跑到右子树里面去了
        root.left = ConstructCore(preorder, startPreorder + 1, startPreorder + (flag - startInorder), Inorder, startInorder, flag - 1);
        root.right = ConstructCore(preorder, startPreorder + (flag - startInorder) + 1, endPreorder, Inorder, flag + 1, endInorder);
        return root;
    }
    
    //2. 已知中序和后序（左右根）
    // startIn=0; endIn=Inorder.length; startLst==0; endLst=lstOrder.length
    TreeNode Constructcore2(int[] Inorder, int startIn, int endIn, int[] lstOrder, int startLst, int endLst) {
        if (startIn > endIn || startLst > endLst) return null;
        int flag=-1;
        TreeNode root=new TreeNode(lstOrder[endLst]);
        for(int i=0; i<endIn;i++){
            if(lstOrder[endLst]==Inorder[i]){
                flag=i;
                break;
            }
        }
        root.left=ConstructCore(Inorder, startIn, flag-1, lstOrder, startLst, flag-startIn+startLst-1);
        root.right=ConstructCore(Inorder, flag+1, endIn, lstOrder, flag-startIn+startLst, endLst-1);
        return root;
    }

}
