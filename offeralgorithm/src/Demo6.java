import java.util.ArrayList;

/**
 * 从尾到头打印链表
 * @author ASUS
 * @since 2018-10-02 19:51
 */
public class Demo6 {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }

        return arrayList;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(0);

        Demo6 demo6 = new Demo6();
        System.out.println(demo6.printListFromTailToHead(listNode));
    }
}

class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }
}
