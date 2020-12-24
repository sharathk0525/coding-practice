package com.edabit.practice;

import java.util.List;

public class MakeClassImmutable {

    public static void main(String[] args) {
        CollectionSortDemo collectionSortDemo = new CollectionSortDemo();
        List<String>       stringList         = collectionSortDemo.getStringList();
        //stringList.add("zzz");
        System.out.println(stringList);
       // collectionSortDemo.name = "sas";
        //collectionSortDemo.num =2;
        System.out.println(collectionSortDemo.getName()+"xxx");
    }
}
