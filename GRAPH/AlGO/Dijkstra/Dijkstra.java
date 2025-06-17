package GRAPH.AlGO.Dijkstra;
import java.util.*;


public class Dijkstra {

    static ArrayList<ArrayList<ArrayList<Integer>>> constructAdj(int[][] edges,int V){
        ArrayList<ArrayList<ArrayList<Integer>>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] egde : edges){
            int u=egde[0];
            int v=egde[1];
            int w=egde[2];

            ArrayList<Integer>  e1=new ArrayList<>();
            e1.add(v);
            e1.add(w);
            adj.get(u).add(e1);

            ArrayList<Integer>  e2=new ArrayList<>();
            e2.add(u);
            e2.add(w);
            adj.get(v).add(e1);
        }
        return adj;
    } 
    static int[] dijkstra(int V,int[][] edges,int src){
        ArrayList<ArrayList<ArrayList<Integer>>> adj=constructAdj(edges, V);
        PriorityQueue<ArrayList<Integer>> pq=new PriorityQueue<>(Comparator.comparingInt(a->a.get(0)));
        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        pq.offer(new ArrayList<>(Arrays.asList(0,src)));
        while(!pq.isEmpty()){
            ArrayList<Integer> curr=pq.poll();
            //int wt=curr.get(0);
            int u=curr.get(1);
            for(ArrayList<Integer> neighbour:adj.get(u)){
                int v=neighbour.get(0);
                int w=neighbour.get(1);
                if(dist[v]>dist[u]+w){
                    dist[v]=dist[u]+w;
                    pq.offer(new ArrayList<>(Arrays.asList(dist[v],v)));
                }
            }
            
        }
        return dist;
    }
    public static void main(String[] args) {
        int V = 5;      
        int src = 0;    

        // Edge list format: {u, v, weight}
        int[][] edges = {
            {0, 1, 4}, {0, 2, 8}, {1, 4, 6},
            {2, 3, 2}, {3, 4, 10}
        };

        // Get shortest path distances
        int[] result = dijkstra(V, edges, src);

        // Print shortest distances in one line
        for (int d : result)
            System.out.print(d + " ");
    }


    
}
