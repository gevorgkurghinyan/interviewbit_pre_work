package com.gevkurg;

import java.util.ArrayList;
import java.util.List;


public class Kth_Smallest_Element_in_the_Array {
  public int kthsmallest(final List<Integer> a, int k) {
    List<Integer> l = new ArrayList<>(a);
    return kthSmallest(l, 0, l.size() - 1, k);
  }

  private int kthSmallest(List<Integer> a, int l, int r, int k)
  {
    // If k is smaller than number of elements in array
    if (k > 0 && k <= r - l + 1)
    {
      // Partition the array around last element and get
      // position of pivot element in sorted array
      int pos = partition(a, l, r);

      // If position is same as k
      if (pos-l == k-1)
        return a.get(pos);
      if (pos-l > k-1)  // If position is more, recur for left subarray
        return kthSmallest(a, l, pos-1, k);

      // Else recur for right subarray
      return kthSmallest(a, pos+1, r, k-pos+l-1);
    }

    // If k is more than number of elements in array
    return Integer.MAX_VALUE;
  }

  private int partition(List<Integer> list, int l, int r) {
    int x = list.get(r);
    int i = l;
    for(int j = l; j < r; ++j) {
      if (list.get(j) <= x) {
        swap(list, i, j);
        ++i;
      }
    }

    swap(list, i, r);
    return i;
  }

  private void swap(List<Integer> list, int i, int j) {
    int temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }
}
