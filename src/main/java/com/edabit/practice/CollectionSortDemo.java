package com.edabit.practice;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class CollectionSortDemo {

       private final List<String> stringList =  Collections.unmodifiableList(Arrays.asList("c", "p", "a", "b", "b"));
       private final List<String> tempList = new ArrayList<>();
       public  final String name;
    public  final int num;



    public List<String> getStringList() {
        return stringList;
        //return tempList;
    }

    public String getName() {
        return name;
    }

    public CollectionSortDemo() {
        tempList.add("a");
        tempList.add("b");
        tempList.add("c");

        name="abc";
        num = 0;
    }
}
