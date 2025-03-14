package ir.dsa.patterns;

public class QueueConcepts {
    public static void main(String args[]) {
        System.out.println("Hello in queues world!");
        DynamicQueue queue = new DynamicQueue(5);
        queue.enque(2);
        queue.enque(3);
        queue.enque(5);
        queue.enque(7);
        queue.enque(9);
   //     queue.enque(1);
        System.out.println("size:"+queue.size());;
        queue.display();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enque(1);
        queue.enque(4);

        System.out.println("size:"+queue.size());;
        queue.display();

    }

    private static class DynamicQueue{

        int[] arr;
        int add;
        int remove;
        int size;
        private DynamicQueue(int capacity){
            arr = new int[capacity];
        }

        private int size(){
     /*       int size;
            if(add == 0 && remove==0){
                size = 0;
            }else if(add == remove){
                size = arr.length;
            } else if(remove<add){
                size = add-remove-1;
            } else{
                size = remove-add+1;
            }*/

        //    System.out.println("size:"+size);
            return size;
        }

        private void enque(int item){

            if(size()==arr.length){
                System.out.println("queue overflow");
                return;
            }

            arr[add] = item;
            add = (add+1)%arr.length;

            size++;
        }

        private void dequeue(){
            if(size()==0){
                System.out.println("queue underflow");
            }
            int item = arr[remove];
            remove = (remove+1)%arr.length;

            size--;
        }

        private void display(){

            if(size() ==0){
                System.out.println("empty queue");
            }

            if(add>remove){

                for(int i = remove; i<add;i++){
                    System.out.print(arr[i]+" ");
                }
            }else{
                for(int j = remove; j<arr.length;j++){
                    System.out.print(arr[j]+" ");
                }

                for(int k =0; k<add;k++){
                    System.out.print(arr[k]+" ");
                }

                System.out.println();
            }
        }
    }
}
