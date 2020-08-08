package com.kuldeep.problems.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

//Time Complexity: O(V+E) with extra space of V
public class DFSBFSDemo {

    private int V; //vertices
    private LinkedList<Integer> adjList[];
    DFSBFSDemo(int v){
        this.V=v;
        adjList = new LinkedList[v];
        for(int i=0; i<v; i++){
            adjList[i] = new LinkedList<>();
        }
    }

    //function to add edge

    public void addEdge(int v, int e){
        adjList[v].add(e);
    }

    public void BFS(int s) {
        boolean visited[] = new boolean[V];

        //create a queue for bfs traversal
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while(!queue.isEmpty()){
            s = queue.poll();
            System.out.print(s+ " ");
            Iterator<Integer> itr = adjList[s].listIterator();
            while (itr.hasNext()){
                int n = itr.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public void dfsWithStack(int s){
        boolean visited[] = new boolean[V];

        //stack for dfs traversal
        Stack<Integer> stack = new Stack<>();

        stack.push(s);
        while(!stack.empty()){
            s = stack.pop();
            System.out.print(s +" ");
            visited[s] = true;
            Iterator<Integer> iterator = adjList[s].listIterator();
            while (iterator.hasNext()){
                int n = iterator.next();
                if(!visited[n]){
                    stack.push(n);
                }
            }
        }
    }

    public void dfsWithoutStack(int s){
        boolean visited[] = new boolean[V];
        dfsUtil(s, visited);
    }

    private void dfsUtil(int s, boolean[] visited) {
        System.out.print(s +" ");
        visited[s] = true;

        Iterator<Integer> iterator = adjList[s].listIterator();
        while (iterator.hasNext()){
            int n = iterator.next();

            if(!visited[n]){
                dfsUtil(n, visited);
            }
        }
    }

    public static void main(String args[]){
        DFSBFSDemo g = new DFSBFSDemo(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2) with stack");
        g.dfsWithStack(2);
        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2) without stack");
        g.dfsWithoutStack(2);
    }
}
