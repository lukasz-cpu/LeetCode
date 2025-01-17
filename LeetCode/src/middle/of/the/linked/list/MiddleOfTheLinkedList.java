package middle.of.the.linked.list;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNode linkedList = LinkedListCreator.createLinkedList();
        ListNode middleNode = findMiddleNode(linkedList);
        System.out.println(middleNode.val);

    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static class LinkedListCreator {
        public static ListNode createLinkedList() {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);

            return head;
        }
    }

    public static ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
