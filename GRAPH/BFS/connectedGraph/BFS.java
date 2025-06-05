package GRAPH.BFS.connectedGraph;

import java.util.*;

class BFS {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int s=0;
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while(!q.isEmpty()){
            int curr=q.poll();
            res.add(curr);
            for(int x:adj.get(curr)){
                if(!visited[x]){
                    q.add(x);
                    visited[x]=true;
                }
            }
        }

     

        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 5;
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).addAll(Arrays.asList(1, 2));
        adj.get(1).addAll(Arrays.asList(0, 2, 3));
        adj.get(2).addAll(Arrays.asList(0, 4));
        adj.get(3).addAll(Arrays.asList(1, 4));
        adj.get(4).addAll(Arrays.asList(2, 3));

        ArrayList<Integer> ans = bfs(adj);
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
