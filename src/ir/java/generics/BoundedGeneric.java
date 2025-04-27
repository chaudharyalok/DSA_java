package ir.java.generics;

import java.util.ArrayList;
import java.util.List;

public class BoundedGeneric {

    public static void main(String arr[]){

    //    System.out.println(calculateMin("alok","sam"));
/*        List<Bucket<String>> list = new ArrayList<>();
        BoundedGeneric.addStore("atom", list);

        // type witness
        //  BoundedGeneric.<String>addStore("atom", list);

        Bucket bucket = list.get(0);
        System.out.println("bucket:"+bucket.getItem());*/

        List<Integer> list = BoundedGeneric.add(new ArrayList<>(), 20,30);
        System.out.println(list);
    }

    public static <T extends Comparable<T>> T calculateMin(T num1, T num2){
        if(num1.compareTo(num2) < 0){
            return  num1;
        }
        return num2;
    }

    public static <T> void addStore(T item, List<Bucket<T>> list){

        Bucket<T> bucket = new Bucket<>();
        bucket.setItem(item);

        list.add(bucket);
        System.out.println("item added to the list:"+item);
    }

    public static <T> List<T> add(List<T> list, T item1, T item2){

        list.add(item1);
        list.add(item2);
        return list;
    }
}

 class Bucket<T>{
    T item;

     public T getItem() {
         return item;
     }

     public void setItem(T item) {
         this.item = item;
     }
 }
