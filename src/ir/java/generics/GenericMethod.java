package ir.java.generics;

public class GenericMethod {

    public <T> T showItem(T item){
        System.out.println("item is:" + item.toString());
        return item;
    }

    public <T,V> void printItems(T item, V value){
        System.out.println("item is:" + item.toString());
        System.out.println("value is:" + value.toString());
    }

    public <T> void printItem(T[] items){
        for(T item : items){
            System.out.println(item);
        }
    }
}
