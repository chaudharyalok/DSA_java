package ir.lld.designpatterns.behavioural.interpreter;

import java.util.HashMap;
import java.util.Map;

public class Context {
    Map<String,Integer> contextMap = new HashMap<>();

    public void put(String value, Integer key){
        contextMap.put(value,key);
    }

    public Integer get(String key){
        return contextMap.get(key);
    }
}
