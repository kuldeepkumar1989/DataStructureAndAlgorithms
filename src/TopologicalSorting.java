import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class TopologicalSorting {
    int v;
    LinkedList<Integer> adj[];

    TopologicalSorting(int v){
        v=v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i]= new LinkedList<>();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void topologicalSort(){
        Stack st = new Stack();
        boolean visited[] = new boolean[v];
        for(int i=0; i<v; i++){
            visited[i]=false;
        }
        for(int i=0; i<v; i++){
            if(visited[i]==false){
                topologicalSortUtil(i,visited,st);
            }
        }
        while(st.empty() == false){
            System.out.println(st.pop());
        }
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack st) {
        visited[v]=true;
        ListIterator itr = adj[v].listIterator();
        while(itr.hasNext()){
            Integer i = (Integer) itr.next();
            if(!visited[i]){
                topologicalSortUtil(i, visited, st);
            }
        }
        st.push(new Integer(v));
    }


}
