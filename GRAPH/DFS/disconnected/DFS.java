package GRAPH.DFS.disconnected;

import java.util.ArrayList;

public class DFS {
    static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj,int s,boolean[] visited, ArrayList<Integer> res){
        visited[s]=true;
        res.add(s);
        for (int i:adj.get(s)){
            if(!visited[i]){
                dfsOfGraph(adj, i, visited, res);
            }
        }
        return res;
    }
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj){
        int V=adj.size();
        ArrayList<Integer> res=new ArrayList<>();
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfsOfGraph(adj, i, visited, res);
            }
        }
        return res;
    }
    static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int V=6;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
         int[][] edges
            = { { 1, 2 }, { 2, 0 }, { 0, 3 }, { 4, 5 } };

        for(int[] edge :edges){
            addEdge(adj, edge[0], edge[1]);
        }

        ArrayList<Integer> res=dfs(adj);

        for(int i:res){
            System.out.print(i+" ");
        }

    }
    
}
