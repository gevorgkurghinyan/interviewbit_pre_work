package com.gevkurg;

public class Subtruct {
  public ListNode subtract(ListNode a) {
    if (a == null || a.next == null) {
      return a;
    }

    ListNode slow = a;
    ListNode fast = a;
    ListNode pre = a;

    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    if (fast != null) {
      pre = pre.next;
      slow = slow.next;
    }

    ListNode secondHead = reverse(slow);

    ListNode p = a;
    ListNode q = secondHead;

    while (q != null) {
      p.val = q.val - p.val;
      p = p.next;
      q = q.next;
    }

    pre.next = reverse(secondHead);

    return a;
  }

  private ListNode reverse(ListNode n) {
    if (n == null || n.next == null) {
      return n;
    }

    ListNode pre = null;
    ListNode current = n;
    ListNode next = null;
    while (current != null) {
      next = current.next;
      current.next = pre;
      pre = current;
      current = next;
    }

    return pre;
  }

  class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
