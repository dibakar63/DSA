from collections import deque
def bfsOfGraph(adj,visited,res,s):
    q=deque()
    visited[s]=True
    q.append(s)
    while q:
        curr=q.popleft()
        res.append(curr)
        for x in adj[curr]:
            if not visited[x]:
                visited[x]=True
                q.append(x)
    return res
def bfs(adj):
    V=len(adj)
    visited=[False]*V
    res=[]
    s=0
    for i in range(V):
        if not visited[i]:
            bfsOfGraph(adj,visited,res,s)
    return res
if __name__=="__main__":
    adj = [[1,2], [0,2,3], [0,4], [1,4], [2,3]]
    ans=bfs(adj)
    for i in ans:
        print(i,end=" ")


