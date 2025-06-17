import heapq
def constructAdj(edges,V):
    adj=[[] for _ in range(V)]
    for u,v,w in edges:
        adj[u].append([v,w])
        adj[v].append([u,w])
    return adj

def dijkstra(V,edges,s):
    adj=constructAdj(edges,V)
    dist=[float('inf')]*V
    dist[s]=0
    pq=[]
    heapq.heappush(pq,(0,s))

    while pq:
        curr=heapq.heappop(pq)
        u=curr[1]
        wt=curr[0]
        for x in adj[u]:
            v=x[0]
            w=x[1]
            if dist[v]>dist[u]+w:
                dist[v]=dist[u]+w
                heapq.heappush(pq,(dist[v],v))
    
    return dist

if __name__=="__main__":
    V = 5
    src = 0

    # edge list format: {u, v, weight}
    edges =[[0, 1, 4], [0, 2, 8], [1, 4, 6], [2, 3, 2], [3, 4, 10]];
    res=dijkstra(V,edges,src)
    print(" ".join(map(str,res)))
