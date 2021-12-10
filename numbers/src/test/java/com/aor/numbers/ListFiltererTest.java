package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    GenericListFilter fred;

    @Test
    public void test1(){
        ArrayList<Integer> sam = new ArrayList<>(Arrays.asList(-1,23,-5,7,98,253));
        ListFilterer greg = new ListFilterer(fred);
        List<Integer> cam = greg.posfilter(sam);
        Assertions.assertEquals(4,cam.size());
    }

    @Test
    public void test2(){
        ArrayList<Integer> sam = new ArrayList<>(Arrays.asList(-1,23,-5,7,98,253));
        ListFilterer greg = new ListFilterer(fred);
        List<Integer> cam = greg.divfilter(sam,23);
        Assertions.assertEquals(2,cam.size());
    }


}
