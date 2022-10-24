package am;

import common.ListNode;

public class MergeTwoLists21Redo {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode res = new ListNode(-1);
		ListNode cur = res;

		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				cur.next = list1;
				list1 = list1.next;
			} else {
				cur.next = list2;
				list2 = list2.next;
			}
			cur = cur.next;
		}

		if (list1 == null) {
			cur.next = list2;
		} else {
			cur.next = list1;
		}

		return res.next;

	}
}
