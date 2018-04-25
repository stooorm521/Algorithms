package DeepCopyVSHardCopy;

//public class RandomListNode {
//    int label;
//    RandomListNode next, random;
//    RandomListNode(int x) { this.label = x; }
//}
//先依次复制所有链表节点，将“新节点”连接在“老节点”后面。并将“新节点”的random设为“老节点”的random值。第二次扫描链表，修正所有“新节点”的random值。
//
//第三次扫描链表，区分开“老链表”和“新链表”形成两个链。时间复杂度为O(N)
public class DeepCopy {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode a, b, fakeHead;
        a = head;
        while (a != null) {
            b = a.next;
            RandomListNode tmp = new RandomListNode(a.label);
            a.next = tmp;
            tmp.next = b;
            tmp.random = a.random;
            a = b;
        }
        a = head;
        //这里开始修正一下，把B的random指向移动到新节点上面来，等下要消除旧结点的
        while (a != null) {
            b = a.next;
            b.random = (b.random != null) ? b.random.next : null;
            a = a.next.next;
        }
//把单双两份Node成功切割开来
        fakeHead = head.next;
        for (a = head, b = fakeHead; ; ) {
            a.next = b.next;
            a = a.next;
            if (a == null) break;
            b.next = a.next;
            b = b.next;
        }
        return fakeHead;
    }
}
