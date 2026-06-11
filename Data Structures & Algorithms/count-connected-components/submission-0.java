class Solution {
    int[] par;
    public int countComponents(int n, int[][] edges) {
        //union find-connected components
        // if(edges.length != n - 1)
        //     return false;
        par=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
        int count=n;
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            if(find(u)==find(v)) continue;
            union(u,v);
            count--;
        }
        return count;
    }
    public int find(int u){
        if(u==par[u]) return u;
        par[u]=find(par[u]);
        return par[u];
    }
    public void union(int u,int v){
        int pu=find(u);
        int pv=find(v);
        if(pu!=pv){
            par[pu]=pv;
        }
    }
}
