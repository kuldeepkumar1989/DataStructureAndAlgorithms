import java.util.Iterator;
import java.util.LinkedList;

public class GraphBFS {
    private int v;
    private LinkedList<Integer> adj[];

    //constructor
    GraphBFS(int v){
        v=v;
        adj= new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }
    void BFS(int s){

        boolean visited[] = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s]=true;
        queue.add(s);
        while(queue.size() != 0){
            s=queue.poll();
            System.out.println(s);
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }

}
