package ir.java.generics.library;

public class Application {
    public static void main(String arr[]){

        Library<Algorithm> library = new Library<>();
        library.add(new GraphAlgo());
        library.add(new SearchingAlgo());
        library.add(new SortingAlgo());

        Algorithm lastItem = library.getLast();
        while(lastItem!=null){
            lastItem.execute();
            lastItem = library.getLast();
        }
    }
}
