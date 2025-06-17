function dfsofGraph(adj,visited,s,res){
    visited[s]=true;
    res.push(s);
    for(let i of adj[s]){
        if(!visited[i]){
            dfsofGraph(adj,visited,i,res);
        }
    }
    return res;

}
function dfs(adj){
    let V=adj.length;
    let visited=Array.from({length:V},(_,i)=>i===false);
    
    let res=[]
    for(let i=0;i<V;i++){
        if(!visited[i]){
            dfsofGraph(adj,visited,i,res);
        }
    }
    return res;
}
function addEdge(adj,u,v){
    adj[u].push(v);
    adj[v].push(u);
}
let V=6;
let adj=Array.from({length:V},()=>[]);
let edges = [[1, 2], [2, 0], [0, 3], [4, 5]];
for(let edge of edges){
    addEdge(adj,edge[0],edge[1]);
}
let res=dfs(adj);
for(let i of res){
    console.log(i+" ");
}