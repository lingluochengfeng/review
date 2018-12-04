package xiaohui.LRUalgorithm;

import java.util.HashMap;

/**
 * LRU算法，全称是：Least Recently Used，最近最少使用算法，
 * 是一种内存管理算法，最早应用于linux
 * LRU算法基于一种假设：长期不被使用的数据，在未来被用到的几率也不大。
 * 因此，当数据所占用内存达到一定阈值时，我们要移除掉最近最少被使用的数据
 * LRU算法中有一种数据结构是哈希链表，Java中的LinkedHashMap已经对哈希链表做了很好的实现
 *
 * 缓存数据库Redis的底层也实现了类似LRU的回收算法
 *
 * 本例子中的代码是线程不安全的，要想线程安全，需要加上synchronized修饰符
 */
public class LRUTest {

    private Node head;

    private Node end;

    //缓存存储上限
    private int limit;

    private HashMap<String, Node> hashMap;

    public LRUTest(int limit){
        this.limit = limit;
        hashMap = new HashMap<String, Node>();
    }

    public String get(String key){
        Node node = hashMap.get(key);
        if (node == null){
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    public void put(String key, String value){
        Node node = hashMap.get(key);
        if (node == null){
            //如果key不存在，插入key-value
            if (hashMap.size() >= limit){
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        }else {
            node.value = value;
            refreshNode(node);
        }
    }

    private void refreshNode(Node node) {
        //如果访问的是尾节点，无需对链表节点进行移动
        if (node == end){
            return;
        }
        //移除节点
        removeNode(node);
        //插入节点
        addNode(node);
    }

    /**
     * 尾部插入节点
     * @param node
     */
    private void addNode(Node node) {
        if (end != null){
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null){
            head = node;
        }
    }

    /**
     * 删除节点
     * @param node
     * @return
     */
    private String removeNode(Node node) {

        if (node == end){
            //移除节点
            end = end.pre;
        }else if (node == head){
            //移除头节点
            head = head.next;
        }else {
            //移除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    public static void main(String[] args) {
        LRUTest lruTest = new LRUTest(5);
        lruTest.put("001", "用户1的消息");
        System.out.println(lruTest.get("001"));
        lruTest.put("002", "用户2的消息");
        lruTest.put("003", "用户3的消息");
        lruTest.put("004", "用户4的消息");
        lruTest.put("005", "用户5的消息");
        System.out.println(lruTest.get("002"));
        lruTest.put("004","用户2信息更新");
        lruTest.put("006", "用户6的信息");
        System.out.println(lruTest.get("001"));
        System.out.println(lruTest.get("006"));
    }

}


class Node{
    public Node pre;
    public Node next;
    public String key;
    public String value;

    public Node(String key, String value){
        this.key = key;
        this.value = value;
    }
}
