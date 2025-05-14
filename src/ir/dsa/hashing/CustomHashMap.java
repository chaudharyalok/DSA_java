package ir.dsa.hashing;

import ir.dsa.patterns.LinkedListConcepts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomHashMap {

    public static void main(String[] args) {
        System.out.println("welcome to recursion:");
    }

    public static class HashMap<K, V> {

        private class HashNode {
            K key;
            V value;

            HashNode(K key, V value){
                this.key = key;
                this.value = value;
            }

        }

        public HashMap(){
            initBuckets(4);
            size = 0;

        }

        private int size;
        private LinkedList<HashNode>[] buckets;

        private void initBuckets(int x){
            buckets = new LinkedList[x];
            for(int i = 0; i< buckets.length; i++){
                buckets[i] = new LinkedList();
            }
        }

        public void put(K key, V value) throws Exception{

            int bi = hashFn(key);
            int di = findWithinBucket(key, bi);

            if(di != -1){
                // update
                HashNode node = buckets[di].get(di);
                node.value = value;
            } else{
                // insert
                HashNode node = new HashNode(key,value);
                buckets[di].add(node);
                size++;
            }

            double lambda = size * 1.0 / buckets.length;
            if(lambda >= 2.0){
                rehash();
            }
        }

        private void rehash() throws Exception{
            LinkedList<HashNode>[] oba = buckets;
            initBuckets(oba.length * 2);
            size = 0;

            for(int i=0; i< buckets.length; i++){
                for(HashNode node: buckets[i]){
                    put(node.key, node.value);
                }

            }
        }

        public V get(K key){

            int bi = hashFn(key);
            int di = findWithinBucket(key, bi);

            if(di != -1){
                return buckets[bi].get(di).value;
            } else{
                return null;
            }
        }

        public boolean containsKey(K key){

            int bi = hashFn(key);
            int di = findWithinBucket(key, bi);

            if(di != -1){
                return true;
            } else{
                return false;
            }
        }

        public V remove(K key){
            int bi = hashFn(key);
            int di = findWithinBucket(key, bi);

            if(di != -1){
                HashNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            } else{
                return null;
            }
        }

        public List<K> keySet(){
            List<K> keys = new ArrayList<>();
            for(int i = 0; i < buckets.length; i++){
               for(HashNode node : buckets[i]){
                   keys.add(node.key);
               }
            }
            return keys;
        }

        public int size(){
            return size;
        }

        private int hashFn(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }

        private int findWithinBucket(K key, int bi){

            int i = 0;
            for(HashNode hashNode : buckets[bi]){
                if(hashNode.key.equals(key)){
                    return i;
                }
                i++;
            }
            return -1;
        }
    }
}
