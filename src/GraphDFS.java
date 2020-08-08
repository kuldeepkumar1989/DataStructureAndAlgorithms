import java.util.LinkedList;
import java.util.ListIterator;

public class GraphDFS {
    private int v;
    private LinkedList<Integer> adj[];
    GraphDFS(int v){
        v=v;
        adj= new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i]= new LinkedList<>();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void DFS(int s){
        boolean visited[] = new boolean[v];
        dfsUtil(v,visited);
    }

    private void dfsUtil(int s, boolean[] visited) {
        System.out.println(s);
        visited[s]=true;
        ListIterator<Integer> itr = adj[s].listIterator();
        while(itr.hasNext()){
            int n = itr.next();
            if(!visited[n]){
                dfsUtil(n,visited);
            }

        }
    }

}
