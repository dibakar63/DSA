from collections import deque
def BFS(adj):
    V=len(adj)
    s=0
    visited=[False]*V
    res=[]
    q=deque()
    q.append(s)
    visited[s]=True
    while q:
        curr=q.popleft()
        res.append(curr)
        for x in adj[curr]:
            if not visited[x]:
                visited[x]=True
                q.append(x)
    return res

if __name__=="__main__":
    
    adj=[
        [1,2],
        [0,3],
        [0,3],
        [1,2,4],
        [3]
    ]
    ans=BFS(adj)
    for i in ans:
        print(i,end=" ")


