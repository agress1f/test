package newcode;
import java.util.HashMap;
import java.util.Map;
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Main25 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode removeNode = pHead;
        // 去创建新链表中的节点元素和原链表节点元素与新链表节点元素之间的映射关系
        while (removeNode != null) {
            RandomListNode node = new RandomListNode(removeNode.label);
            map.put(removeNode, node);
            removeNode = removeNode.next;
        }
        removeNode = pHead;
        // 去创建新链表中每个节点的结构关系(根据原链表的节点的结构关系)
        while (removeNode != null) {
            RandomListNode node = map.get(removeNode);
            node.next = map.get(removeNode.next);
            node.random = map.get(removeNode.random);
            removeNode = removeNode.next;
        }
        return map.getOrDefault(pHead, null);
    }
}
