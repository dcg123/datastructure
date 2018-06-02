package FindingAPath;

import java.util.Stack;
import java.util.Vector;

public class Path {
    private Graph G;   // 图的引用
    private int s;     // 起始点
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int[] from;         // 记录路径, from[i]表示查找的路径上i的上一个节点

    //构造函数 寻路算法 寻找图graph从s到其他点的路径
    public Path(Graph graph,int s){
        G=graph;
        assert s>=0&&s<G.V();

        visited=new boolean[G.V()];
        from=new int[G.V()];
        for (int i=0;i<G.V();i++){
            visited[i]=false;
            from[i]=-1;
        }
        this.s=s;
        dfs(s);
    }

    private void dfs(int v) {
        visited[v]=true;
        for (int i:G.adj(v)){
            if (!visited[i]){
                from[i]=v;
                dfs(i);
            }
        }
    }

    // 查询从s点到w点是否有路径
    boolean hasPath(int w){
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    //查询从s到w点的路径 存放在Vector中
    Vector<Integer> path(int w){
        assert hasPath(w) ;
        Stack<Integer> stack=new Stack<>();
        int p=w;
        while (p!=-1){
            stack.push(p);
            p=from[p];
        }
        Vector<Integer> res=new Vector<>();
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    // 打印出从s点到w点的路径
    void showPath(int w){

        assert hasPath(w) ;

        Vector<Integer> vec = path(w);
        for( int i = 0 ; i < vec.size() ; i ++ ){
            System.out.print(vec.elementAt(i));
            if( i == vec.size() - 1 )
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }
}
