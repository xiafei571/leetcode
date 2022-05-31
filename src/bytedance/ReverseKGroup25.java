package bytedance;

import java.util.ArrayList;
import java.util.List;

import common.ListNode;

public class ReverseKGroup25 {
	public ListNode reverseKGroup(ListNode head, int k) {
		List<ListNode> heads = new ArrayList<>();
		List<Integer> group = new ArrayList<>();

		ListNode p = head;
		while (p != null) {
			heads.add(p);
			int cnt = 1;
			while (cnt < k && p.next != null) {
				p = p.next;
				cnt++;
			}
			group.add(cnt);
			ListNode temp = p.next;
			p.next = null;
			p = temp;
		}

		// reverse
		for (int i = 0; i < heads.size(); i++) {
			ListNode h = heads.get(i);
			if (group.get(i) == k) {
				h = reverse(h);
			}
			heads.set(i, h);
		}

		// combin
		for (int i = 0; i < heads.size() - 1; i++) {
			ListNode h = heads.get(i);
			while (h.next != null) {
				h = h.next;
			}
			h.next = heads.get(i + 1);
		}

		return heads.get(0);
	}

	private ListNode reverse(ListNode head) {
		ListNode last = null;
		ListNode curr = head;
		ListNode next;

		while (curr != null) {
			next = curr.next;
			curr.next = last;
			last = curr;
			curr = next;
		}

		return last;
	}
}
