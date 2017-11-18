package com.gevkurg;

import java.util.ArrayList;
import java.util.Stack;


public class NextGreater {
  public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
    if (a == null || a.size() == 0) {
      return a;
    }

    Stack<Integer> s = new Stack<Integer>();
    s.push(0);

    for (int i = 1; i < a.size(); ++i) {
      if (!s.isEmpty()) {
        while(true) {
          if (s.isEmpty() || a.get(i) <= a.get(s.peek())) {
            break;
          }

          a.set(s.pop(), a.get(i));
        }
      }

      s.push(i);
    }

    while(!s.isEmpty()) {
      a.set(s.pop(), -1);
    }

    return a;
  }
}
