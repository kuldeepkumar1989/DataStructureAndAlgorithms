import java.util.Iterator;
import java.util.LinkedList;

public class GraphPractice {
    int V;

    //an array of type linkedlist
    // like int [] arr = new int[5] // integer type array

    LinkedList<Integer> adjList[];
    GraphPractice(int v){
        V = v;
        adjList = new LinkedList[V];

        //create a new list for each vertex, such that adjacent nodes can be stored
        for(int i=0; i<V; i++){
            adjList[i] = new LinkedList<>();
        }
    }
    //add edge
    void addEdge(int v, int w){
     adjList[v].add(w);
    }
    //print bfs from given source
    void BFS(int s){
        boolean visited[]= new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while(queue.size()!=0){
            //dequeue the vertex and print it
            s = queue.poll();
            System.out.println(s+" ");
            //Get all adjacent vertices of the dequeued vertex s
            //if a adjacent has not been visited, then mark it visited and enqueue it
            Iterator<Integer> itr = adjList[s].listIterator();
            while(itr.hasNext()){
                int n = itr.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void DFS(int s){
        boolean visited[] = new boolean[V];
        DFSUtil(s, visited);
    }

    private void DFSUtil(int s, boolean[] visited) {
        visited[s] = true;
        System.out.println(s+" ");
        Iterator<Integer> itr = adjList[s].listIterator();
        while (itr.hasNext()){
            int n = itr.next();
            if(!visited[n]){
                DFSUtil(n, visited);
            }
        }
    }

    public static void main(String args[]){
        GraphPractice graph = new GraphPractice(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);

        System.out.println("BFS for graph : ");
        graph.BFS(2);
        System.out.println("DFS for graph : ");
        graph.DFS(2);
    }
}
