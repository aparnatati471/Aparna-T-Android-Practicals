package com.example.javakotlinpracticals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CollectionFramework {
    public static void collection()
    {
        System.out.println("\nCollections");
        List<Integer> list=new ArrayList<>();
        list.add(500);
        list.add(220);
        list.add(100);
        Collections.addAll(list,400,350);//add one or more elements
        for(int i=0;i<list.size();i++)
            System.out.print(list.get(i)+" ");

        Collections.sort(list);//sort the list
        System.out.println("\n"+list);

        System.out.println(Collections.binarySearch(list,220));//gives index using the binarysearch to search the element

        List<Integer> list1=new ArrayList<>();
        list1.add(10);
        list1.add(20);

        Collections.copy(list,list1);//copy all the elements of one list to another
        System.out.println(list);

        System.out.println(Collections.disjoint(list,list1));//to check the two list are disjoint or not

    }

    public static void arrayList()
    {
        System.out.println("ArrayList");
        //ArrayList Example
        ArrayList<String> arrayList=new ArrayList<>();//creates empty array of size 10 in internal memory
        arrayList.add("Java");
        arrayList.add("Kotlin");      /*when you add 11th item on it will again create size of array like if size is n then at the time of inserting 11th item it will create
                                        size of array like n+n/2+1 and copy all the previous 10 elements into that*/
        System.out.println(arrayList);//prints the arraylist on terminal

        arrayList.add("Swift");
        System.out.println(arrayList);

        arrayList.add("Java");  //arraylist allows us to store duplicate elements
        System.out.println(arrayList);

        arrayList.add(2,"IOS");//This will add IOS item at specified index
        System.out.println(arrayList);

        List<String> oops=new ArrayList<>();
        oops.add("Class & Objects");
        oops.add("Inheritence");
        oops.add("Polymorphisam");

        arrayList.addAll(oops);//This will add whole list
        System.out.println(arrayList);

        //Get Element
        System.out.println(arrayList.get(2)); //this will get item by specified index

        //Remove Element
        arrayList.remove(2); //Delete item by index
        System.out.println(arrayList);

        arrayList.remove("Class & Objects");//Delete item by name
        System.out.println(arrayList);

        arrayList.set(2,"IOS");//This will updates the item at index 2

        System.out.println(arrayList.contains("Java"));//to check whether item present or not

        //printing element with its index
        for(int i=0;i<arrayList.size();i++)
        {
            System.out.println("Element at index "+i+" is:"+arrayList.get(i));
        }
        arrayList.clear();//deletes all the items
    }
    public static void linkedList()
    {
        System.out.println("\nLinked List");
        LinkedList<Integer> linkedList=new LinkedList<>();//creates empty linked list
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
        System.out.println(linkedList.pollFirst());//removes last element
    }
    public static void map()
    {
        System.out.println("\nMap");
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"Apple");
        map.put(2,"Oppo");//This will add elements to map
        System.out.println(map.keySet()+"\n"+map.values());//it will display our keyset and valueset

        System.out.println(map.containsKey(1));//to check key is present or not

        System.out.println(map.containsValue("Oppo"));//to check key is present or not

        //display key with value
        for(Map.Entry<Integer, String> mapentry:map.entrySet())
        {
            String val=mapentry.getValue();
            Integer key=mapentry.getKey();
            System.out.println(key+":"+val);
        }
    }
    public static void main(String[] args) {
        arrayList();
        linkedList();
        collection();
        map();
    }
}
