def dfsOfGraph(adj,s,visited,res):
    visited[s]=True
    res.append(s)
    for i in adj[s]:
        if not visited[i]:
            dfsOfGraph(adj,i,visited,res)
    return res
def dfs(adj):
    V=len(adj)
    visited=[False]*V
    res=[]
    s=0
    for i in range(V):
        if not visited[i]:
            dfsOfGraph(adj,i,visited,res)
    return res
def addEdge(adj,u,v):
    adj[u].append(v)
    adj[v].append(u)

if __name__=="__main__":
    V=6
    adj=[[] for _ in range(V)]
    edges = [[1, 2], [2, 0], [0, 3], [4, 5]];
    for u,v in edges:
        addEdge(adj,u,v)
    ans=dfs(adj)
    for i in ans:
        print(i,end=" ")

