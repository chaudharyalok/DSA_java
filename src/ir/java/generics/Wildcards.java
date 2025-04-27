package ir.java.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wildcards {
    public static void main(String arr[]){

        List<Integer> list = Arrays.asList(1,2,3);
      //  print(list); compile time error because List<Integer> is not subtype of List<Object>
      // solution is wildcard
   //     printCollection(list);

        List<? super Integer> l1 = new ArrayList<Integer>();
        List<? super Integer> l2 = new ArrayList<Number>();
        List<? super Integer> l3 = new ArrayList<Object>();


        List<Serializable> list1 = new ArrayList<>();
        list1.add("abc");
        list1.add("efg");
        list1.add("hjk");

        showAll(list1);

        List<? super Number> list4 = new ArrayList<>();
        list4.add(3);
        list4.add(3.5);
        list4.add(3.6f);

    }

    private static void showAll(List<? super Integer> list){
        // only object can be used here because it is the parent of all types of object,
        // any other type cause compile time error
        for(Object num: list){
            System.out.println(num);
        }

    }

    private static void printCollection(List<?> list){

        for(Object o : list){
            System.out.println(o);
        }
    }

    private static void print(List<Object> list){

        for(Object o : list){
            System.out.println(o);
        }
    }
}
