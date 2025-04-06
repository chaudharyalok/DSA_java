package ir.dsa.patterns;

import java.util.*;
import java.util.function.Consumer;

public class TreeConcepts {

    private static class GenericTree implements Iterable<Integer>{
        Node root;

        public GenericTree(Node root) {
            this.root = root;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new GenericTreeIterator(root);
        }

        @Override
        public void forEach(Consumer<? super Integer> action) {
            Iterable.super.forEach(action);
        }

        @Override
        public Spliterator<Integer> spliterator() {
            return Iterable.super.spliterator();
        }
    }

    private static class GenericTreeIterator implements Iterator<Integer>{

        Integer nval;
        Stack<Pair1> stack;

        public GenericTreeIterator(Node root) {
            stack = new Stack<>();
            stack.push(new Pair1(root,-1));
            next();
        }

        @Override
        public boolean hasNext() {
            if(nval == null){
                return false;
            }else {
                return true;
            }
        }

        @Override
        public Integer next() {
            Integer fr = nval;

            nval = null;
            while(!stack.empty()){
                Pair1 top = stack.peek();
                if(top.state == -1){
                    nval = top.node.data;
                    top.state++;
                    break;
                } else if(top.state == top.node.children.size()){
                    stack.pop();
                } else{
                    Pair1 pair = new Pair1(top.node.children.get(top.state),-1);
                    stack.push(pair);
                    top.state++;
                }

            }
            return fr;
        }
    }

    private static class Pair1{
        Node node;
        int state;

        public Pair1(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    private static class Node{

        Node(){

        }

        Node(int data){
            this.data = data;
        }
        int data;
        List<Node> children = new ArrayList<>();
    }

    private static class Pair{
        Node node;
        int level;

        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }

    static Node root;
    public static void main(String args[]) {
        System.out.println("Hello in Tree world!");
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        int[] arr2 = {10,20,-1,30,50,-1,60,-1,-1,40,-1,-1};
        Node root = constructTree(arr2);

        GenericTree genericTree = new GenericTree(root);
        Iterator<Integer> iterator = genericTree.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
   //     preorderIterativeBinaryTree(root);
  //      displayPostorder(root);
   //     displayPreorder(root);
    //    display(root);

   //     System.out.println("size of tree->"+size(root));
   //     System.out.println("max in tree->"+max(root));
   //     System.out.println("height in tree->"+height(root));
    //    levelTraversal(root);
     //   levelTraversalLineWise(root);
   //     levelTraversalLineWiseZigzag(root);
   //     levelTraversalLineWise2(root);
   //     levelTraversalLineWise3(root);
  //      levelTraversalLineWise4(root);
    //    mirror(root);
    //    removeLeafs(root);
    //    linearize(root);
    //    linearize2(root);
  //      levelTraversalLineWise4(root);
        List<Node> list = new ArrayList<>();
   //     System.out.println("value present"+ find(root, 80));
     /*   System.out.println("value present"+ nodeToRootPath(root, 80,list));
        for(Node node : list) {
            System.out.print( node.data+" ");
        }*/

    //    System.out.println("path to root " + nodeToRootPath2(root,80));

  //      System.out.println("lowest common ancestor " + lowestCommonAncestor(root,80,100));
   //       System.out.println("lowest common ancestor " + distanceBw2Nodes(root,50,110));

   /*     int[] arr1 = {11,21,51,-1,61,-1,-1,31,71,-1,81,111,-1,121,-1,-1,91,-1,-1,41,101,2,-1,-1,-1};
        Node root2 = constructTree(arr1);*/
    //    System.out.println("similar " + areSimilar(root,root2));

 /*       int[] arr2 = {10,20,-1,30,50,-1,60,-1,-1,40,-1,-1};
        Node root3 = constructTree(arr2);
        System.out.println("similar " + isSymmetric(root3));*/

/*        multiSolver(root,0);
        System.out.println("size: " + size);
        System.out.println("max: " + max);
        System.out.println("min: " + min);
        System.out.println("height: " + height);*/

/*        setPredecessorSuccessor(root,120);
        System.out.println("predecessor: " + predecessor.data);
        System.out.println("sucessor: " + sucessor.data);*/


/*        setFloorCeiling(root, 120);
        System.out.println("floor: " + floor);
        System.out.println("ceiling: " + ceiling);*/

  //      System.out.println("kth largest: " + kthLargest(root,5));
/*        int[] arr3 = {10,20,-50,-1,-60,-1,-1,30,-70,-1,80,-110,-1,120,-1,-1,90,-1,-1,40,-100,-1,-1,-1};
        Node root3 = constructTree(arr3);
        largestSumSubTree(root3);
        System.out.println("sum: " + sum);*/

    }

    // multi solver approach
    static int  size;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int height;

    static Node predecessor;
    static Node sucessor;
    static int state;

    static int ceiling = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;

    static int sum = Integer.MIN_VALUE;

    static int dis = 0;

    private static int calculateDiaReturnHeight(Node node){

        int dch = -1;
        int sdch  = -1;

        for(Node child : node.children){

            int ch = calculateDiaReturnHeight(child);
            if(ch > dch){
                sdch = dch;
                dch = ch;
            } else if(ch > sdch){
                sdch = ch;
            }
        }

        if(dch + sdch  +2 > dis){
            dis = dch + sdch  +2;
        }
        dch+=1;
        return dch;
    }

    private static int largestSumSubTree(Node node){

        int value = node.data;

        int sum1 = 0;
        for(Node child : node.children){
           sum1 = sum1 + largestSumSubTree(child);
        }

        sum = Math.max(sum, sum1+value);
        return sum1+value;

    }
    private static int kthLargest(Node node,int k){


        int factor = Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            setFloorCeiling(node, factor);
            factor = floor;
            floor = Integer.MIN_VALUE;
        }

        return factor;
    }
    private static void setFloorCeiling(Node node, int value){

        if(node.data > value){
            if(node.data < ceiling){
                ceiling = node.data;
            }
     //       ceiling = Math.min(ceiling,node.data);

        }  else if(node.data < value){
                if(node.data > floor){
                    floor = node.data;
                }
       //     floor = Math.max(floor,node.data);
        }

        for(Node child: node.children){
            setFloorCeiling(child,value);
        }

    }

    private static void setPredecessorSuccessor(Node node, int value){

        if(state == 0){
            if(node.data == value){
                state = 1;
            } else{
                predecessor = node;
            }
        } else if(state == 1){
            sucessor = node;
            state = 2;
        }

        for(Node child: node.children){
            setPredecessorSuccessor(child,value);
        }

    }
    private static void multiSolver(Node node, int depth){

        size++;
        max = Math.max(max,node.data);
        min = Math.min(min,node.data);
        height = Math.max(depth,height);

        for(int i=0;i<node.children.size();i++){
            multiSolver(node.children.get(i),depth+ 1);
        }


    }

    private static boolean isSymmetric(Node node){
       return mirrorImage(node,node);

    }

    private static boolean mirrorImage(Node node1, Node node2){
        if(node1.children.size() != node2.children.size()){
            return false;
        }

        for(int i =0; i<node1.children.size(); i++){
            int j = node1.children.size()-1 -i;
            Node child1 = node1.children.get(i);
            Node child2 = node2.children.get(j);
            if(!mirrorImage(child1,child2)){
                return false;
            }
        }
        return true;
    }

    private static boolean areSimilar(Node node1, Node node2){

        if(node1.children.size() != node2.children.size()){
            return false;
        }

        for(int i =0; i<node1.children.size(); i++){
            Node child1 = node1.children.get(i);
            Node child2 = node2.children.get(i);
            if(!areSimilar(child1,child2)){
                return false;
            }
        }
        return true;
    }

    private static int distanceBw2Nodes(Node node, int v1, int v2){
        List<Integer> path1 = nodeToRootPath2(node,v1);
        List<Integer> path2 = nodeToRootPath2(node,v2);

        int i = path1.size()-1;
        int j = path2.size()-1;

        while(i>=0 && j>= 0 && path1.get(i) == path2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;

        return i+j;

    }

    private static int lowestCommonAncestor(Node node, int v1, int v2){
        List<Integer> path1 = nodeToRootPath2(node,v1);
        List<Integer> path2 = nodeToRootPath2(node,v2);

        int i = path1.size()-1;
        int j = path2.size()-1;
        while(i>=0 && j>= 0 && path1.get(i) == path2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;

        return path1.get(i);
    }

    private static List<Integer> nodeToRootPath2(Node node, int value){

        if(node.data == value){
            List<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }

        for(Node child : node.children){
            List<Integer> cnr = nodeToRootPath2(child,value);
            if(cnr.size()>0){
                cnr.add(node.data);
                return cnr;
            }
        }

        return Collections.emptyList();
    }

    private static boolean nodeToRootPath(Node node, int value, List<Node> nodes){

        if(node.data == value){
            nodes.add(node);
            return true;
        }

        for(Node child : node.children){
            System.out.print(child.data + " ");
            boolean temp = nodeToRootPath(child,value,nodes);
            if(temp){
                nodes.add(node);
                return true;
            }
        }
        return false;
    }

    private static boolean find(Node node, int value){
       if(node.data == value){
            return true;
        }
        else{
            boolean flag = false;

            for(Node child: node.children){
                System.out.print(child.data + " ");
                flag = flag || find(child,value);
                if(flag){
                    return true;
                }
            }
            return flag;
        }
    }

    private static boolean find2(Node node, int value){

        if(node.data == value){
            return true;
        }

        for(Node child : node.children){
            System.out.print(child.data + " ");
            boolean temp = find2(child,value);
            if(temp){
                return true;
            }
        }
        return false;
    }

    private static Node linearize2(Node node){

        if(node.children.size() == 0){
            return node;
        }
        Node lkt = linearize2(node.children.get(node.children.size()-1));
        while(node.children.size() > 1){
            Node last = node.children.remove(node.children.size()-1);
            Node sl = node.children.get(node.children.size()-1);
            Node slt = linearize2(sl);
            slt.children.add(last);
        }
        return lkt;
    }

    private static void linearize(Node node){

        for(Node child: node.children){
            linearize(child);
        }

        while(node.children.size() > 1){
            Node lc = node.children.remove(node.children.size()-1);
            Node sc = node.children.get(node.children.size()-1);
            Node tail = getTail(sc);
            tail.children.add(lc);

        }
    }

    private static Node getTail(Node node){
        while(node.children.size() ==1){
            node = node.children.get(0);
        }
        return node;
    }


    private static void removeLeafs(Node node){

        for(int i = node.children.size()-1; i>=0; i--){
             Node child = node.children.get(i);
             if(child.children.size() == 0){
                    node.children.remove(child);
             }
        }

        for(Node child : node.children){
            removeLeafs(child);
        }
    }

    private static void mirror(Node node){
        for(Node child : node.children){
            mirror(child);
        }
        Collections.reverse(node.children);
    }

    private static void levelTraversalLineWiseZigzag(Node node){

        Stack<Node> ms = new Stack<>();
        Stack<Node> cs = new Stack<>();

        ms.push(node);
        boolean right = true;
        while(!ms.isEmpty()){
            Node temp = ms.pop();
            System.out.print(temp.data + " ");

             if(right){
                 for(int i = 0; i< temp.children.size(); i++){
                     cs.add(temp.children.get(i));
                 }
             }else {
                 for (int i = temp.children.size() - 1; i >= 0; i--) {
                     cs.add(temp.children.get(i));
                 }
             }

             if(ms.isEmpty()){
                 ms = cs;
                 cs = new Stack<>();
                 System.out.println();
                 right = ! right;
             }
        }
    }

    private static void levelTraversalLineWise(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        Queue<Node> child_queue = new ArrayDeque<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            for(Node child : temp.children){
                child_queue.add(child);
            }

            if(queue.isEmpty()){
                queue = child_queue;
                child_queue = new ArrayDeque<>();
                System.out.println();
            }


        }

    }

    private static void levelTraversalLineWise2(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        queue.add(new Node(-1));

        while(!queue.isEmpty()){

            Node temp = queue.poll();
            if(temp.data != -1) {
                System.out.print(temp.data + " ");
                for (Node child : temp.children) {
                    queue.add(child);
                }
            } else {
                if(!queue.isEmpty()){
                    queue.add(new Node(-1));
                    System.out.println();
                }
            }
        }
    }

    private static void levelTraversalLineWise3(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while(!queue.isEmpty()) {

            int cl = queue.size();
            for (int i = 0; i < cl; i++) {
                Node temp = queue.poll();
                System.out.print(temp.data + " ");
                for (Node child : temp.children) {
                    queue.add(child);
                }

            }
            System.out.println();

        }
    }

    private static void levelTraversalLineWise4(Node node){
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(node,1));

        int level = 1;
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            if(temp.level > level){
                level = temp.level;
                System.out.println();
            }
            System.out.print(temp.node.data + " ");
            for (Node child : temp.node.children) {
                queue.add(new Pair(child,level+1));
            }

        }

    }

    private static void levelTraversal(Node node){

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            for(Node child : temp.children){
                queue.add(child);
            }
        }
        System.out.print(".");
    }

    private static int height(Node node){
        int he = 0; // for nodes 0, for edges -1
        for(Node child : node.children){
            int ch = height(child);
            he = Math.max(he,ch);
        }
        he+=1;
        return he;

    }

    private static int max(Node node){

        int max = Integer.MIN_VALUE;

        for(Node child : node.children){
            int cm = max(child);
            max = Math.max(max, cm);
        }
        max = Math.max(max, node.data);
        return max;
    }

    private static int size(Node node){
        int s = 0;
        for(Node child : node.children){
           int cs = size(child);
           s = s + cs;
        }
        s = s+1;
        return s;
    }

    private static void display(Node node){

        String s = node.data + " :-> ";
        for(Node child : node.children){
            s+= child.data + ", ";
        }
        System.out.println(s);

        for(Node child : node.children){
            display(child);
        }


    }

    private static void displayPreorder(Node node){
        System.out.print(node.data + " ");

        for(Node child : node.children){
            displayPreorder(child);
        }

    }

    private static void displayPostorder(Node node){


        for(Node child : node.children){
            displayPostorder(child);
        }

        System.out.print(node.data + " ");

    }

    private static void preorderIterativeBinaryTree(Node node){

        String pre = "";
        String post = "";
        Stack<Pair1> stack = new Stack<>();

        stack.push(new Pair1(node,-1));

        while(!stack.isEmpty()){

            Pair1 top = stack.peek();

            if(top.state == -1){
                pre+= top.node.data + " ";
                top.state++;

            } else if(top.state == top.node.children.size()){
                post+= top.node.data + " ";
                stack.pop();
            } else {
                Pair1 pair = new Pair1(top.node.children.get(top.state),-1);
                stack.push(pair);

                top.state++;
            }
        }

        System.out.println(pre);
        System.out.println(post);

    }

    private static Node constructTree(int arr[]){

    //    Node root;
        Stack<Node> stack = new Stack<>();
        for(int i=0; i< arr.length; i++){
            if(arr[i] == -1){
                stack.pop();
            } else{
                Node n = new Node();
                n.data = arr[i];

                if(stack.size() == 0){
                    root = n;
                } else{
                    stack.peek().children.add(n);
                }
                stack.push(n);
            }
        }
        return root;
    }


}
