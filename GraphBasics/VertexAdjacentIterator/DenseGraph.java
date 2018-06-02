package VertexAdjacentIterator;


import java.util.Vector;

//稠密图 邻接矩阵
public class DenseGraph {
    private int n;//节点数
    private int m;//边数
    private boolean directed;//是否是有向图
    private boolean [][]g; //图的具体数据

    // 构造函数
    public DenseGraph( int n , boolean directed ){
        assert n >= 0;
        this.n = n;
        this.m = 0;    // 初始化没有任何边
        this.directed = directed;
        // g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false, 表示没有任和边
        // false为boolean型变量的默认值
        g = new boolean[n][n];
    }

    public int V(){ return n;} // 返回节点个数
    public int E(){ return m;} // 返回边的个数

    //向图中添加一个边
    private void addEdge(int v,int w){
        assert v>=0&&v<n;
        assert w>=0&&w<n;

        if (hasEdege(v,w)){
            return;
        }
        g[v][w]=true;
        if (!directed){
            g[w][v]=true;
        }
        m++;
    }

    private boolean hasEdege(int v, int w) {
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;
        return g[v][w];
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    public Iterable<Integer> adj(int v){
        assert v >= 0 && v < n;
        Vector<Integer> vector=new Vector<>();
        for (int i=0;i<n;i++){
            if (g[v][i]){
                vector.add(i);
            }
        }
        return vector;
    }
}
