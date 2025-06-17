package GRAPH.BFS.disconnectedGraph;
import java.util.*;
class BFS {
    static ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int s,ArrayList<Integer> res){
        Queue<Integer> q=new LinkedList<>();
          visited[s]=true;
          q.add(s);
          while(!q.isEmpty()){
            int curr=q.poll();
            res.add(curr);
            for(int x:adj.get(curr)){
                if(!visited[x]){
                    visited[x]=true;
                    q.add(x);
                }
            }
            
          }
          return res;

    }
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj){
        int V=adj.size();
        ArrayList<Integer> res=new ArrayList<>();
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                bfsOfGraph(adj,visited,i,res);
            }
        }
        return res;
    }
    public static void main(String[] args){
          ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0))); 
        adj.add(new ArrayList<>(Arrays.asList(0)));   
        adj.add(new ArrayList<>(Arrays.asList(4)));
        adj.add(new ArrayList<>(Arrays.asList(3, 5)));
        adj.add(new ArrayList<>(Arrays.asList(4)));  

        //int src = 0;
        ArrayList<Integer> ans = bfs(adj);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

}
