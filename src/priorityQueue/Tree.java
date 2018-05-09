package priorityQueue;

import DataMining.RadomForest.TreeNode;

public class Tree {
    //Node 类中包含 key 值，用于确定节点在树中相应位置，value 值代表要存储的内容
    //比较是比较的key值
    Node root;//保存树的根

    public Node find(int key) {
        //查找指定节点, 如果找不到，则返回null
        Node currentNode = root;
        while (currentNode != null && currentNode.key != key) {
            if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
            } else
                currentNode = currentNode.rightChild;

        }
        return currentNode;
    }

    public void insert(int key, int value) {//插入节点
        if (root == null) {
            root = new Node(key, value);
            return;
        }
        //只保证在最后一行插入，也维护了二叉树的基本性质，但不是类似大顶堆小顶堆的结构
        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftChild = true;
        while (currentNode != null) {
            parentNode = currentNode;
            if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
                isLeftChild = true;
            } else {
                currentNode = currentNode.rightChild;
                isLeftChild = false;
            }
        }
        Node newNode = new Node(key, value);
        if (isLeftChild)
            parentNode.leftChild = newNode;
        else
            parentNode.rightChild = newNode;


    }

    public void delete(int key) {//删除指定节点
//       在二叉搜索树中删除节点操，可分为以下三种情况。
//　　　　1、待删除的节点为叶子节点，可直接删除。
        Node currentNode = root;//用来保存待删除节点
        Node parentNode = root;//用来保存待删除节点的父亲节点
        boolean isLeftChild = true;//用来确定待删除节点是父亲节点的左孩子还是右孩子
        while (currentNode != null && currentNode.key != key) {
            parentNode = currentNode;
            if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
                isLeftChild = true;
            } else {
                currentNode = currentNode.rightChild;
                isLeftChild = false;
            }
        }
        //找到了想要删除的节点
        if (currentNode == null) return;
        if (currentNode.leftChild == null && currentNode.rightChild == null) {
            if (currentNode == root) root = null;
            else if (isLeftChild) parentNode.leftChild = null;
            else if (!isLeftChild) parentNode.rightChild = null;
        }
    }

//    private Node getDirectPostNode(Node delNode) {//得到待删除节点的直接后继节点
//
//    }

    public void preOrder(Node rootNode) {//先序遍历树
        if (rootNode != null) {
            //递归调用此处只能写if语句而不是while
            System.out.println(rootNode.key + " " + rootNode.value);
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }

    public void inOrder(Node rootNode) {//中序遍历树
        if (rootNode != null) {
            preOrder(rootNode.leftChild);
            System.out.println(rootNode.key + " " + rootNode.value);
            preOrder(rootNode.rightChild);
        }
    }

    public void postOrder(Node rootNode) {//后序遍历
        if (rootNode != null) {
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
            System.out.println(rootNode.key + " " + rootNode.value);
        }
    }


}
