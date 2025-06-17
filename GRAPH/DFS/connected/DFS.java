package GRAPH.DFS.connected;
import java.util.*;

public class DFS {
    static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int s,ArrayList<Integer> res){
        visited[s]=true;
        res.add(s);
        for(int i: adj.get(s)){
            if(!visited[i]){
                dfsOfGraph(adj,visited,i,res);
            }
        }
        return res;
    }
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj){
        int V=adj.size();
        boolean[] visited=new boolean[V];
        ArrayList<Integer> res=new ArrayList<>();
        int s=0;
        dfsOfGraph(adj,visited,s,res);
        return res;

    }
    static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void main(String[] args){
        int V=5;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int [][] edges={ { 1, 2 },{ 1, 0 },{ 2, 0 },{ 2, 3 },{ 2, 4 } }; 
        for(int[] edge:edges){
            addEdge(adj,edge[0],edge[1]);
        }
        ArrayList<Integer> res=dfs(adj);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
       

    }
}
