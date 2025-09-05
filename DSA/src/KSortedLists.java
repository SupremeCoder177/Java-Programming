import java.util.PriorityQueue;
import java.util.Queue;

public class KSortedLists {
    public static ListNode mergeKLists(ListNode[] lists){
        if(lists == null || lists.length == 0) return null;
        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode node : lists){
            if(node != null) pq.add(node);
        }
        if(pq.isEmpty()) return null;

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;

            if(minNode.next != null){
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode[] list = new ListNode[3];
        ListNode temp1 = new ListNode(5);
        ListNode temp2 = new ListNode(4, temp1);
        ListNode temp3 = new ListNode(1, temp2);
        ListNode temp4 = new ListNode(4);
        ListNode temp5 = new ListNode(3, temp4);
        ListNode temp6 = new ListNode(1, temp5);
        ListNode temp7 = new ListNode(6);
        ListNode temp8 = new ListNode(2, temp7);
        list[0] = temp3;
        list[1] = temp6;
        list[2] = temp8;

        ListNode output = mergeKLists(new ListNode[]{temp3, temp6});
        System.out.println(output);
    }

}
