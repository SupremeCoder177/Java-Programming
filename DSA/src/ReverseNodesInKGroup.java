public class ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k){
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode();
        ListNode tail =  dummy;

        boolean firstLoop = true, breakWhole = false;
        while(true){
            ListNode[] nodes = new ListNode[k];
            for(int i = 0; i < k; i++){
                if(head == null) {
                    breakWhole = true;
                    break;
                }
                nodes[i] = head;
                head = head.next;
            }
            if(breakWhole){
                tail.next = nodes[0];
                break;
            }

            if(firstLoop){
                dummy.next = nodes[k - 1];
                firstLoop = false;
            }
            for(int i = k - 1; i > 0; i--){
                nodes[i].next = nodes[i - 1];
            }

            tail.next = nodes[k - 1];
            tail = nodes[0];
        }
        return dummy.next;
    }

    public static void main(String[] args){

        ListNode a = new ListNode(5);
        ListNode b = new ListNode(4, a);
        ListNode c = new ListNode(3, b);
        ListNode d = new ListNode(2, c);
        ListNode e = new ListNode(1, d);

        ListNode output = reverseKGroup(e, 2);

        System.out.println(output);

    }
}
