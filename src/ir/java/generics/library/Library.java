package ir.java.generics.library;

import java.util.ArrayList;
import java.util.List;

public class Library<T extends Algorithm> {
    List<T> algos;

    public Library(){
        algos = new ArrayList<>();
    }

    public void add(T algo){
        this.algos.add(algo);
    }

    public T getLast(){
        if(algos.size()<=0){
            return null;
        }

        T actualAlgo = algos.remove(algos.size()-1);
        return actualAlgo;
    }
}
