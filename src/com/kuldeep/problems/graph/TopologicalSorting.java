package com.kuldeep.problems.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

//Time Complexity: O(V+E) with extra space of V
public class TopologicalSorting {
    private int V;
    private LinkedList<Integer> adj[];
    TopologicalSorting(int v){
        this.V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v;i++){
            adj[i]= new LinkedList<>();
        }
    }

    public void addEdge(int v, int e){
        adj[v].add(e);
    }

    public void topologicalSort(){
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<V; i++){
            if(!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

    }

    private void topologicalSortUtil(int start, boolean[] visited, Stack stack) {
        visited[start] = true;
        Iterator<Integer> iterator = adj[start].listIterator();
        while(iterator.hasNext()){
            int n = iterator.next();
            if(!visited[n]){
                topologicalSortUtil(n, visited, stack);
            }
        }
        stack.push(start);
    }

    public static void main(String args[]){
        TopologicalSorting g = new TopologicalSorting(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.topologicalSort();
    }
}
