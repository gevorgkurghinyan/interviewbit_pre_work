package com.gevkurg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class All_Unique_Permutations {
  public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if(a==null || a.size()==0) return result;
    boolean[] used = new boolean[a.size()];
    List<Integer> list = new ArrayList<Integer>();
    a.sort(Comparator.comparingInt(x -> x));
    permute(a, used, list, result);
    return result;
  }

  public void permute(ArrayList<Integer> nums, boolean[] used, List<Integer> list, ArrayList<ArrayList<Integer>> res){
    if(list.size()==nums.size()){
      res.add(new ArrayList<Integer>(list));
      return;
    }
    for(int i=0;i<nums.size();i++){
      if(used[i]) continue;
      if(i>0 &&nums.get(i-1)==nums.get(i) && !used[i-1]) continue;
      used[i]=true;
      list.add(nums.get(i));
      permute(nums,used,list,res);
      used[i]=false;
      list.remove(list.size()-1);
    }
  }
}
