package com.aor.numbers;

import java.util.Iterator;
import java.util.List;

public class ListFilterer {

    GenericListFilter filter;

    public ListFilterer(GenericListFilter filter1){
        this.filter= new PositiveFilter();
    };
    public List<Integer> posfilter(List<Integer> list){
        list.removeIf(integer -> !filter.accept(integer));
        return list;
    }

    public List<Integer> divfilter(List<Integer> list, int n){
        DivisibleByFilter filter2 = new DivisibleByFilter(n);
        list.removeIf(integer -> !filter2.accept(integer));
        return list;
    }
}
