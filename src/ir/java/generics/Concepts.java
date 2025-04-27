package ir.java.generics;

import java.util.Hashtable;

class Store{
    Object item;

     public Object getItem() {
         return item;
     }

     public void setItem(Object item) {
         this.item = item;
     }
 }

//generic example
class Store1<T>{
    T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

// multiple generic types
class HashTable<K,V>{
     private K key;
     private V value;

    public HashTable(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "hashTable{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

public class Concepts {

    public static void main(String arr[]){
/*        System.out.println("generics: ");
        // to avoid method overloading we use generics
        // raw type
        Store store = new Store();
        store.setItem(45);
    //  store.setItem(45.0); problematic ode
        Integer value = (Integer) store.getItem();
        System.out.println("item is:"+value);*/

 /*       Store1<String> store1 = new Store1<>();
        store1.setItem("abc");
        // when we set any value other than string it gives compile tim error
        //  store1.setItem(10);
        String output = store1.getItem();
        System.out.println("item1 is:"+output);*/

/*        HashTable<String,Integer> table = new HashTable<>("abc",2);
        System.out.println(table);*/
        GenericMethod genericMethod = new GenericMethod();
        // any type of value can be passed here
     //   genericMethod.printItems("abc",3);
     //   System.out.println(genericMethod.showItem("avc"));
        int[] int_array = {1,2,3,4}; // generics don't work with primitive type arrays
        Integer[] INT_array = {1,2,3,4};
        String[] nameArray = {"abc","dfg","dfh","qwwe"};
        genericMethod.printItem(nameArray);

    }
}
