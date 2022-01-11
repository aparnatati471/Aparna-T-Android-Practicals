package com.example.javakotlinpracticals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CollectionFramework {

    //Collection Demo
    public static void collection() {
        System.out.println("\nCollections");

        List<Integer> list = new ArrayList<>();
        list.add(500);
        list.add(220);
        list.add(100);

        //add one or more elements
        Collections.addAll(list, 400, 350);
        for(int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");

        //sort the list
        Collections.sort(list);
        System.out.println("\n" + list);

        //gives index using the binarySearch to search the element
        System.out.println(Collections.binarySearch(list,220));

        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);

        //copy all the elements of one list to another
        Collections.copy(list, list1);
        System.out.println(list);

        //to check the two list are disjoint or not
        System.out.println(Collections.disjoint(list, list1));
    }

    //ArrayList Demo
    public static void arrayList()
    {
        System.out.println("ArrayList");

        //creates empty array of size 10 in internal memory
        /*when you add 11th item on it will again create size of array like if size is n then at the time of inserting 11th item it will create
        size of array like n+n/2+1 and copy all the previous 10 elements into that*/
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("Kotlin");
        System.out.println(arrayList);

        arrayList.add("Swift");
        System.out.println(arrayList);

        //arraylist allows us to store duplicate elements
        arrayList.add("Java");
        System.out.println(arrayList);

        //This will add IOS item at specified index
        arrayList.add(2,"IOS");
        System.out.println(arrayList);

        List<String> oops = new ArrayList<>();
        oops.add("Class & Objects");
        oops.add("Inheritence");
        oops.add("Polymorphisam");

        //This will add whole list
        arrayList.addAll(oops);
        System.out.println(arrayList);

        //Get Element by index
        System.out.println(arrayList.get(2));

        //Remove Element by index
        arrayList.remove(2);
        System.out.println(arrayList);

        //Remove item by name
        arrayList.remove("Class & Objects");
        System.out.println(arrayList);

        //This will updates the item at index 2
        arrayList.set(2, "IOS");

        //to check whether item present or not
        System.out.println(arrayList.contains("Java"));

        //printing element with its index
        for(int i = 0; i < arrayList.size(); i++) {
            System.out.println("Element at index "+i+" is:"+arrayList.get(i));
        }

        //deletes all the items
        arrayList.clear();
    }

    //Linked List Demo
    public static void linkedList()
    {
        System.out.println("\nLinked List");
        //creates empty linked list
        LinkedList<Integer> linkedList = new LinkedList<>();

        //Add Elements
        linkedList.add(10);//add element in linked list
        System.out.println(linkedList);

        linkedList.addFirst(20);//add element at beginning of linked list
        System.out.println(linkedList);

        linkedList.addLast(30);//add element at end of linked list
        System.out.println(linkedList);

        linkedList.add(2,40);//add element at specified position of linked list
        System.out.println(linkedList);

        linkedList.add(3,20);
        System.out.println(linkedList);

        //Get Elements
        System.out.println(linkedList.element());//it will get first element in linkedlist
        System.out.println(linkedList.getFirst());//it will get first element in linkedlist
        System.out.println(linkedList.getLast());//it will get last element in linkedlist
        System.out.println(linkedList.indexOf(20));//it will return index of first occurence of element and returns -1 is not present
        System.out.println(linkedList.lastIndexOf(20));//it will return index of last occurence of element and returns -1 is not present
        System.out.println(linkedList.offer(60));//adds element at last
        System.out.println(linkedList.offerFirst(70));//adds element at first
        System.out.println(linkedList.offerLast(90));//adds element at last
        System.out.println(linkedList.peek());//reterive first element
        System.out.println(linkedList.poll());//removes first element
        System.out.println(linkedList.pollFirst());//removes first element
        System.out.println(linkedList.pollLast());//removes last element
    }

    //Map Demo
    public static void map()
    {
        System.out.println("\nMap");

        //Creation of Map and add the elements
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Apple");
        map.put(2,"Oppo");

        //it will display our keyset and valueset
        System.out.println(map.keySet()+ "\n" +map.values());

        //to check key is present or not
        System.out.println(map.containsKey(1));

        //to check key is present or not
        System.out.println(map.containsValue("Oppo"));

        //display key with value
        for(Map.Entry<Integer, String> mapentry:map.entrySet()) {
            String val = mapentry.getValue();
            Integer key = mapentry.getKey();
            System.out.println(key+ ":" +val);
        }
    }

    public static void main(String[] args) {
        arrayList();
        linkedList();
        collection();
        map();
    }
}
