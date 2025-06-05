function BFS(adj){
    let V=adj.length;
    let s=0;
    let visited=new Array(V).fill(false);
    let res=[];
    let q=[];
    q.push(s);
    visited[s]=true;
    while(q.length>0){
        let curr=q.shift();
        res.push(curr)
        for(let x of adj[curr]){
            if(!visited[x]){
                visited[x]=true;
                q.push(x);
            }
        }
    }
    return res
}
let v=5;

let adj = 
    [ [1,2], [0,2,3], [0,4], [1,4], [2,3]];
let src = 0;
let ans = BFS(adj);
for (let i of ans) {
    console.log(i + " ");
}