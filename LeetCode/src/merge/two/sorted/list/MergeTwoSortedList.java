package merge.two.sorted.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        // Tworzenie listy list1 = [5, 6, 7]
        ListNode firstNode = new ListNode(5);
        firstNode.next = new ListNode(6);
        firstNode.next.next = new ListNode(7);

        // Tworzenie listy list2 = [1, 3, 4]
        ListNode secondNode = new ListNode(1);
        secondNode.next = new ListNode(3);
        secondNode.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(firstNode, secondNode);
        System.out.println(listNode);


    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        List<Integer> resultList = new ArrayList<>();

        while (list1 != null) {
            resultList.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            resultList.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(resultList);

        ListNode tempNode = new ListNode();
        ListNode resultNode = tempNode;


        for (Integer i : resultList) {
            tempNode.next = new ListNode(i);
            tempNode = tempNode.next;
        }
        resultNode = resultNode.next;


        return resultNode;
    }
}


