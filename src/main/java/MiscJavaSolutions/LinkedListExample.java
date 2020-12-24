package MiscJavaSolutions;

import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String args[])
    {
        LinkedList<String> ll = new LinkedList<>();

        ll.add("Geeks");
        ll.add("Geeks");
        ll.add(1, "Geeks sharath");

        System.out.println("Initial LinkedList " + ll);

        ll.set(1, "For");

        System.out.println("Updated LinkedList " + ll);
    }
}
