package com.gevkurg;

import java.util.HashMap;
import java.util.List;


public class Longest_Consecutive_Sequence {
  public int longestConsecutive(final List<Integer> a) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int max = 0;
    for(Integer n : a) {
      if (!map.containsKey(n)) {
        int left = map.containsKey(n - 1) ? map.get(n-1) : 0;
        int right = map.containsKey(n + 1) ? map.get(n+1) : 0;
        int sum = left + 1 + right;
        map.put(n, sum);
        max = Math.max(max, sum);

        map.put(n - left, sum);
        map.put(n + right, sum);
      } else {
        continue;
      }
    }

    return max;
  }
}
