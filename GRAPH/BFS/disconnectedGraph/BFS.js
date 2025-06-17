function bfsOfGraph(adj,res,visited,s){
    let q=[]
    q.push(s);
    visited[s]=true;
    while(q.length>0){
        let curr=q.shift();
        res.push(curr);
        for(let x of adj[curr]){
            if(!visited[x]){
                visited[x]=true;
                q.push(x);
            }
        }
    }
    return res;
}
function bfs(adj){
    let V=adj.length;
    let visited=new Array(V).fill(false);
    let res=[]
    for (let i=0;i<V;i++){
        if(!visited[x]){
            bfsOfGraph(adj,res,visited,i);
        }
    }
    return res;
}

adj = [[1,2], [0,2,3], [0,4], [1,4], [2,3]]
let ans = bfs(adj);
for (let i of ans) {
    console.log(i + " ");
}