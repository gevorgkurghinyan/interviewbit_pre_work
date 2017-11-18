package com.gevkurg;

import java.util.ArrayList;


public class PrettyPrint {
  public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    int size = 2 * a - 1;
    for (int i = 0; i < size; ++i) {
      result.add(new ArrayList<>(size));

      for (int j = 0; j < size; ++j) {
        result.get(i).add(0);
      }
    }

    int rowStart = 0;
    int rowEnd = size - 1;
    int colStart = 0;
    int colEnd = size - 1;

    int i = a;
    while (rowStart <= rowEnd && colStart <= colEnd) {
      for (int j = colStart; j <= colEnd; ++j) {
        result.get(rowStart).set(j, i);
      }

      ++rowStart;

      for (int j = rowStart; j <= rowEnd; ++j) {
        result.get(j).set(colEnd, i);
      }

      --colEnd;

      if (colStart <= colEnd) {

        for (int j = colEnd; j >= colStart; --j) {
          result.get(rowEnd).set(j, i);
        }

        --rowEnd;
      }

      if (rowStart <= rowEnd) {

        for (int j = rowEnd; j >= rowStart; --j) {
          result.get(j).set(colStart, i);
        }

        ++colStart;
      }

      --i;
    }

    return result;
  }
}
