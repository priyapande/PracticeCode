package main.LeetCodeMedium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MergeKList {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode(0);
        List<Integer> check = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) check.add(i);
        }
        int min = Integer.MAX_VALUE;
        int index = 0;
        ListNode it = ans;
        while (!check.isEmpty()) {
            for (int i : check) {
                if (lists[i] == null) check.remove(i);
                else if (lists[i].val < min) {
                    min = lists[i].val;
                    index = i;
                }
            }
            it.next = new ListNode(lists[index].val);
            it = it.next;
            lists[index] = lists[index].next;
            min = Integer.MAX_VALUE;
        }
        return ans.next;
    }

    @Test
    public void shouldMergeKListsInSortedOrder() {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        System.out.println(mergeKLists(lists).val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}