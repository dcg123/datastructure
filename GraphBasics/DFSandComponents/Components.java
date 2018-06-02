package DFSandComponents;


//dfs 求联通分量
public class Components {
    Graph g;
    private boolean[] visited;//记录dfs过程中节点是否被访问
    private int count;//记录联通分量的个数
    private int []id ;//记录每个节点对应的联通分量标记

    //构造函数，求出无权图的联通分量
    public Components(Graph graph){
        g=graph;
        visited=new boolean[g.V()];
        id=new int[g.V()];
        count=0;

        for(int i=0;i<g.V();i++){
            if (!visited[i]){
                dfs(i);
                count++;
            }
        }

    }

    private void dfs(int v) {
        id[v]=count;
        visited[v]=true;
        for (int i:g.adj(v)){
            if (!visited[i]){
                dfs(i);
            }
        }
    }
    // 返回图的联通分量个数
    int count(){
        return count;
    }

    // 查询点v和点w是否联通
    boolean isConnected( int v , int w ){
        assert v >= 0 && v < g.V();
        assert w >= 0 && w < g.V();
        return id[v] == id[w];
    }
}
