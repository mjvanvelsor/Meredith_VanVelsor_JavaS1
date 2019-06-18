package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetIterator {

    public void printSet(int a, int b, int c, int d, int e){
        Set<Integer> fiveInts = new HashSet< >();

        fiveInts.add(a);
        fiveInts.add(b);
        fiveInts.add(c);
        fiveInts.add(d);
        fiveInts.add(e);

        Iterator<Integer> iter = fiveInts.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}
