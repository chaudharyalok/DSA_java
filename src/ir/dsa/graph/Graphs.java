package ir.dsa.graph;

import java.util.*;

/**
 * shortest path in terms of edges: BFS
 */

public class Graphs {
    static class Edge{
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        System.out.println("welcome to Graphs:");

        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for(int i = 0; i < vertices; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,3,40));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,10));

        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,10));

        graph[3].add(new Edge(3,0,40));
        graph[3].add(new Edge(3,2,10));
        graph[3].add(new Edge(3,4,2));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,3));
        graph[4].add(new Edge(4,6,8));

        graph[5].add(new Edge(5,4,3));
        graph[5].add(new Edge(5,6,3));

        graph[6].add(new Edge(6,4,8));
        graph[6].add(new Edge(6,5,3));

        boolean[] visited = new boolean[vertices];

   //     System.out.println("path exists:" +  hasPath(graph, 0,6,visited));
  //      allPaths(graph,0,6,visited,"0");
  //      allPathsMultiSolver(graph,0,6,visited,"0",0, 50,2);
   //     isGraphConnected(graph,7);
/*        System.out.println("smallest path:" +  minPath);
        System.out.println("largest path:" +  maxPath);
        System.out.println("criteria floor:" +  ctFloor);
        System.out.println("criteria ceiling:" +  ctCeiling);
        System.out.println("kth largest:" +  priorityQueue.peek().wsf);*/
    //    graphBFS(graph, 7, 2);
    //    checkCyclic(graph, 7);
    //    prims(graph, 0, vertices);
   //     dijkstraAlgo(graph,0, vertices);
  //      iteDFS(graph,0, vertices);

        int friends = 7;
        int edges = 5;
        String[] pairs = {"0 1","3 2","4 5","4 6","5 6"};
   //     perfectFriends(friends, edges, pairs);

        ArrayList<Edge>[] graph1 = new ArrayList[vertices];
        for(int i = 0; i < vertices; i++){
            graph1[i] = new ArrayList<>();
        }
        graph1[0].add(new Edge(0,1,40));
        graph1[1].add(new Edge(1,0,40));

        graph1[2].add(new Edge(2,3,40));
        graph1[3].add(new Edge(3,2,40));

        graph1[4].add(new Edge(4,5,40));
        graph1[4].add(new Edge(4,6,40));

        graph1[5].add(new Edge(5,4,40));
        graph1[5].add(new Edge(5,6,40));

        graph1[6].add(new Edge(6,4,40));
        graph1[6].add(new Edge(6,5,40));

    //    allConnectedComponents(graph1, 7);
   //     isGraphConnected(graph1,7);


        // no of islands
        int[][] islands = {{0,0,1,1,1,1,1,1},{0,0,1,1,1,1,1,1},{1,1,1,1,1,1,1,0},
                           {1,1,0,0,0,1,1,0},{1,1,1,1,0,1,1,0},{1,1,1,1,0,1,1,0},
                           {1,1,1,1,1,1,1,0},{1,1,1,1,1,1,1,0}};
   //     noOfIslands(islands);


        /**
         * DAG for topological sort
         */
        ArrayList<Edge>[] graph2 = new ArrayList[vertices];
        for(int i = 0; i < vertices; i++){
            graph2[i] = new ArrayList<>();
        }

        graph2[0].add(new Edge(0,3,0));
        graph2[0].add(new Edge(0,1,0));

        graph2[1].add(new Edge(1,2,0));

        graph2[2].add(new Edge(2,3,0));

        graph2[4].add(new Edge(4,3,0));
        graph2[4].add(new Edge(4,5,0));
        graph2[4].add(new Edge(4,6,0));

        graph2[5].add(new Edge(5,6,0));

     //   topologicalSort(graph2, vertices);
        int i = 057;
        System.out.println(i);
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){

        if(src == dest){
            return true;
        }

        visited[src] = true;
        for(Edge edge : graph[src]){
            if(visited[edge.nbr] == false){
               boolean hasNbrPath = hasPath(graph, edge.nbr, dest,visited);
               if(hasNbrPath){
                   return true;
               }
            }
        }
        return false;
    }

    public static void allPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String pathsSoFar){

        if(src == dest){
            System.out.println(pathsSoFar);
            return;
        }

        visited[src] = true;
        for(Edge edge : graph[src]){
            if(visited[edge.nbr] == false){
                allPaths(graph, edge.nbr, dest,visited,pathsSoFar+edge.nbr);
            }
        }
        visited[src] = false;
    }

    /**
     * multi solver,
     * smallest path
     * largest path
     * ceil path @ criteria 42
     * floor path @ criteria 42
     * kth largest path
     */

    public static class Pair implements Comparable<Pair>{
        int wsf;
        String psf;

        Pair(int wsf, String psf){
            this.wsf = wsf;
            this.psf = psf;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }
    static Integer minPath = Integer.MAX_VALUE;
    static Integer maxPath = Integer.MIN_VALUE;

    // smallest in values larger than criteria
    static Integer ctCeiling = Integer.MAX_VALUE;

    // largest in values smaller than criteria
    static Integer ctFloor = Integer.MIN_VALUE;
    static PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();

    public static void allPathsMultiSolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String pathsSoFar, int wtSoFar, int criteria,int k){

        if(src == dest){
            // largest path
            if(wtSoFar > maxPath ){
                maxPath = wtSoFar;
            }
            // smallest path
            if(wtSoFar < minPath){
                minPath = wtSoFar;
            }
            // criteria ceiling value
            if(wtSoFar > criteria && wtSoFar < ctCeiling){
                ctCeiling = wtSoFar;
            }
            // criteria floor value
            if(wtSoFar < criteria && wtSoFar > ctFloor){
                ctFloor = wtSoFar;
            }

            // Kth largest element
            if(priorityQueue.size() < k){
                priorityQueue.add(new Pair(wtSoFar, pathsSoFar));
            } else{
                if(wtSoFar > priorityQueue.peek().wsf){
                    priorityQueue.remove();
                    priorityQueue.add(new Pair(wtSoFar, pathsSoFar));
                }
            }


            System.out.println(pathsSoFar);
            return;
        }

        visited[src] = true;
        for(Edge edge : graph[src]){
            if(visited[edge.nbr] == false){
                allPathsMultiSolver(graph, edge.nbr, dest,visited,pathsSoFar+edge.nbr, wtSoFar+edge.wt, criteria, k);
            }
        }
        visited[src] = false;
    }

    /**
     *  is graph connected
     */
    private static void isGraphConnected(ArrayList<Edge>[] graph, int vertices){
        boolean[] visited = new boolean[vertices];
        List<List<Integer>> comps = new ArrayList<>();
        for(int v = 0; v< vertices; v++){
            if(visited[v] == false){
                List<Integer> comp = new ArrayList<>();
                drawTreeAndGenerateComponent(graph,v,comp, visited);
                comps.add(comp);
            }
        }
        System.out.println("is connected: " + (comps.size()==1));

    }
    /**
     * get connected component
     *
     */

    private static List<List<Integer>> allConnectedComponents(ArrayList<Edge>[] graph, int vertices){

        boolean[] visited = new boolean[vertices];
        List<List<Integer>> comps = new ArrayList<>();
        for(int v = 0; v< vertices; v++){
            if(visited[v] == false){
                List<Integer> comp = new ArrayList<>();
                drawTreeAndGenerateComponent(graph,v,comp, visited);
                comps.add(comp);
            }
        }
        System.out.println("all components" + comps);
        return comps;
    }

    private static void drawTreeAndGenerateComponent(ArrayList<Edge>[] graph, int src, List<Integer> comp,boolean[] visited){
        visited[src] = true;
        comp.add(src);
        for(Edge edge : graph[src]){
            if(visited[edge.nbr] == false){
                drawTreeAndGenerateComponent(graph, edge.nbr,comp, visited);
            }
        }
    }

    /**
     * virtual graph
     * count number of islands using graph
     */
    private static void noOfIslands(int[][] arr){

        boolean[][] visited = new boolean[arr.length][arr[0].length];

        int count = 0;
        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j< arr[i].length;j++){
                if(arr[i][j] == 0 && visited[i][j] == false){
                    drawTreeOfComponent(arr, i, j, visited);
                    count++;
                }

            }
        }
        System.out.println("noOfIslands: " + count);

    }

    private static void drawTreeOfComponent(int[][] arr, int i, int j, boolean[][] visited){

        // base cases
        if(i<0 || j<0 || j>= arr[0].length || i>= arr.length || arr[i][j]==1 || visited[i][j] == true){
            return;
        }
        visited[i][j] = true;
        drawTreeOfComponent(arr, i, j-1, visited);
        drawTreeOfComponent(arr, i, j+1, visited);
        drawTreeOfComponent(arr, i-1, j, visited);
        drawTreeOfComponent(arr, i+1, j, visited);

    }

    /** TODO
     * hamiltonian path & cycles in graph and graph theory
     *
     */

    /**
     * breadth first traversal in graph
     * remove, mark *, work, add *
     */

    public static class Pair1{
        int v;
        String psf;

        Pair1(int v, String psf){
            this.v = v;
            this.psf = psf;
        }
    }

    private static void graphBFS(ArrayList<Edge>[] graph, int vertices, int src){

        ArrayDeque<Pair1> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[vertices];

        // remove, mark*, work, add*
        queue.add(new Pair1(src, src+""));

        while(queue.size() >0){
            Pair1 rem = queue.removeFirst();

            if(visited[rem.v] == true){
                continue;
            }
            visited[rem.v] = true;

            System.out.println(rem.v +" @ " + rem.psf);
            for(Edge edge : graph[rem.v]){
                if(visited[edge.nbr] == false){
                    queue.add(new Pair1(edge.nbr, rem.psf + edge.nbr));
                }
            }

        }
    }

    /**
     * is graph cyclic
     */
    private static void checkCyclic(ArrayList<Edge>[] graph, int vertices){

        boolean[] visited = new boolean[vertices];
        for(int v = 0; v< vertices; v++){
            if(visited[v] == false){
                boolean cycle = isCyclic(graph, v, visited);
                if(cycle){
                    System.out.println("cycle present");
                    return;
                }
            }
        }
        System.out.println("cycle not present");
    }

    private static boolean isCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited){

        ArrayDeque<Pair1> queue = new ArrayDeque<>();

        // remove, mark*, work, add*
        queue.add(new Pair1(src, src+""));

        while(queue.size() >0){
            Pair1 rem = queue.removeFirst();

            if(visited[rem.v] == true){
                return true;
            }
            visited[rem.v] = true;

      //      System.out.println(rem.v +" @ " + rem.psf);
            for(Edge edge : graph[rem.v]){
                if(visited[edge.nbr] == false){
                    queue.add(new Pair1(edge.nbr, rem.psf + edge.nbr));
                }
            }

        }
        return false;

    }

    /**
     * bipartite graph
     * if it is possible
     * to divide vertices into
     * 2 mutually exclusive and exhaustive sets
     * such that all edges are across sets
     *
     */

    public static class Pair2{
        int v;
        String psf;
        int level;

        Pair2(int v, String psf, int level){
            this.v = v;
            this.psf = psf;
            this.level = level;
        }
    }

    private static void isBipartite(ArrayList<Edge>[] graph, int vertices){

        int[] visited = new int[vertices];
        Arrays.fill(visited,-1);
        for(int i=0; i<vertices; i++){
            if(visited[i] == -1) {
                boolean isCheckPass = checkComponentForBipartiteness(graph, i, visited);
                if(isCheckPass == false){
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }

    private static boolean checkComponentForBipartiteness(ArrayList<Edge>[] graph, int src, int[] visited){

        ArrayDeque<Pair2> queue = new ArrayDeque<>();
        queue.add(new Pair2(src, src + "", 0));

        while(queue.size() > 0){
            Pair2 rem = queue.removeFirst();

            if(visited[rem.v] != -1){
                // check for visited at same level, if not it is odd cycle, so non-bipartite
                if(rem.level != visited[rem.v]){
                    return false;
                }
            } else{
                visited[rem.v] = rem.level;
            }

            for(Edge edge : graph[rem.v]){
                if(visited[edge.nbr] == -1){
                    queue.add(new Pair2(edge.nbr, rem.psf + edge.nbr, rem.level+1));
                }
            }
        }
        return true;
    }

    /** spread infection
     *  if single node takes time of 1 unit to infect, and t+1 to its immediate neighbour
     *  count the number of infections after T time
     */

    public static class Pair3{
        int v;
        int time;

        Pair3(int v, int time){
            this.v = v;
            this.time = time;
        }
    }

    private static void countInfection(ArrayList<Edge>[] graph, int src, int vertices, int time){

        int[] infected = new int[vertices];
        int count = 0;
        ArrayDeque<Pair3> queue = new ArrayDeque<>();
        queue.add(new Pair3(src, 1));

        while(queue.size()>0){
            Pair3 rem = queue.removeFirst();

            if(infected[rem.v] > 0){
                continue;
            }
            infected[rem.v] = rem.time;
            if(rem.time > time){
                break;
            }

            count++;

            for(Edge edge : graph[rem.v]){
                if(infected[edge.nbr] == 0) {
                    queue.add(new Pair3(edge.nbr, rem.time + 1));
                }
            }

        }
        System.out.println("total infected count:" + count);

    }

    /** Dijkstra | single source Shortest path in weights
     *  it is same as BFS, just we replace queue with priority queue
     *  and remove element with shortest path so far
     */
    public static class Pair4 implements Comparable<Pair4>{
        int v;
        String psf;
        int wsf;

        Pair4(int v, String psf, int wsf){
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(Pair4 o) {
            return this.wsf - o.wsf;
        }
    }

    private static void dijkstraAlgo(ArrayList<Edge>[] graph, int src, int vertices){

        boolean[] visited = new boolean[vertices];
        PriorityQueue<Pair4> queue = new PriorityQueue<>();

        queue.add(new Pair4(src, src+"", 0));
        while(queue.size() > 0){
            Pair4 rem = queue.remove();

            if(visited[rem.v] == true){
                continue;
            }
            visited[rem.v] = true;
            System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);

            for(Edge edge : graph[rem.v]){
                if(visited[edge.nbr] == false){
                    queue.add(new Pair4(edge.nbr, rem.psf + edge.nbr, rem.wsf+ edge.wt));
                }
            }
        }
    }

    /**
     * prims algo
     */

    public static class Pair5 implements Comparable<Pair5>{
        int v;
        int av;
        int wt;

        Pair5(int v, int av, int wt){
            this.v = v;
            this.av = av;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair5 o) {
            return this.wt - o.wt;
        }
    }

    private static void prims(ArrayList<Edge>[] graph, int src, int vertices){

        boolean[] visited = new boolean[vertices];
        PriorityQueue<Pair5> queue = new PriorityQueue<>();
        queue.add(new Pair5(0,-1,0));

        while(queue.size()>0){
            Pair5 rem = queue.remove();

            if(visited[rem.v] == true){
                continue;
            }

            visited[rem.v] = true;

            if(rem.av != -1){
                System.out.println("[" + rem.v + "-" + rem.av + "@" + rem.wt + "]");
            }

            for(Edge edge : graph[rem.v]){
                if(visited[edge.nbr] == false){
                    queue.add(new Pair5(edge.nbr, rem.v, edge.wt));
                }
            }
        }
    }

    /**
     * iterative depth first search
     * using stack
     */
    public static class Pair6{
        int v;
        String psf;

        Pair6(int v, String psf){
            this.v = v;
            this.psf = psf;
        }
    }

    private static void iteDFS(ArrayList<Edge>[] graph, int src, int vertices){
        boolean[] visited = new boolean[vertices];

        Deque<Pair6> stack = new ArrayDeque<>();
        stack.push(new Pair6(0, "0"));

        while(stack.size() > 0){
            Pair6 rem = stack.pop();

            if(visited[rem.v] == true){
                continue;
            }
            visited[rem.v] = true;

            System.out.println(rem.v + "@" + rem.psf);

            for(Edge edge : graph[rem.v]){
                if(visited[edge.nbr] == false){
                    stack.push(new Pair6(edge.nbr, rem.psf+edge.nbr));
                }
            }
        }

    }

    /**
     * perfect friends
     *
     */

    private static void perfectFriends(int friends, int edges, String[] pairs){

        ArrayList<Edge>[] graph = new ArrayList[friends];
        for(int v=0; v<friends; v++ ){
            graph[v] = new ArrayList<>();
        }

        for(int e=0; e<edges; e++){
            String edge = pairs[e];
            String[] part = edge.split(" ");
            int v1 = Integer.parseInt(part[0]);
            int v2 = Integer.parseInt(part[1]);

            graph[v1].add(new Edge(v1,v2,0));
            graph[v2].add(new Edge(v2,v1,0));
        }

        List<List<Integer>> comps = allConnectedComponents(graph, friends);

        int pairs_output = 0;
        for(int i=0; i< comps.size(); i++){
            for(int j=i+1; j< comps.size(); j++){
                int count = comps.get(i).size() * comps.get(j).size();
                pairs_output+=count;
            }
        }

        System.out.println(""+pairs_output);
    }

    /** topological sort
     *
     *
     */

    private static void topologicalSort(ArrayList<Edge>[] graph, int vertices){

        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        for(int v = 0; v<vertices; v++){
            if(visited[v] == false){
                topologicalRecur(graph, v, visited, stack);
            }
        }


        while(stack.size()>0){
            System.out.print(stack.pop()+" ");
        }
    }

    private static void topologicalRecur(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> stack){

        visited[src] = true;
        for(Edge edge : graph[src]){
            if(visited[edge.nbr] == false){
                topologicalRecur(graph, edge.nbr, visited, stack);
            }
        }
        stack.push(src);
    }
}
