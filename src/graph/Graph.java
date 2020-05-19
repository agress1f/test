package graph;

import sun.security.provider.certpath.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;//存储定点集合
    private int[][] edges;//邻接矩阵
    private int numOfEdges;//边的数目
    private boolean[] isVisited;
    public static void main(String[] args) {
        //测试图的创建
        int n=5;
        String VertexValue[] = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        //循环添加顶点
        for (String vertex: VertexValue){
            graph.insertVertex(vertex);
        }

        //添加边
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
       // graph.insertEdge(0,1,1);
        //显示
        //graph.showGraph();
        //测试dfs
//        System.out.println("深度遍历");
//        graph.dfs();
        System.out.println("广度遍历");
        graph.bfs();
    }

    //构造器
    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[5];
    }

    //得到第一个邻接节点的下标
    public int getFirstNeighbor(int index){
        for (int j=0;j<vertexList.size();j++){
            if (edges[index][j]>0){
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2){
        for (int j=v2+1;j<vertexList.size();j++){
            if (edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    private void dfs(boolean[] isVisited,int i){
        //受限访问该节点
        System.out.print(getValueByIndex(i)+"->");
        //将节点设置为已访问
        isVisited[i] = true;
        //查找结点i的第一个邻接结点
        int w = getFirstNeighbor(i);
        while (w!=-1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            //如果w结点已经被访问过
            w = getNextNeighbor(i,w);
        }
    }

    //对dfs进行一个重载，遍历我们所有节点，并进行dfs
    public void dfs(){
        //
        for (int i=0;i<getNumOfVertex();i++){
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }
    private void bfs(boolean[] isVisited,int i){
        int u;//表示队列头结点的下标
        int w;//邻接结点w
        //队列，记录结点访问顺序
        LinkedList queue = new LinkedList();
        //访问结点，输出结点信息
        System.out.print(getValueByIndex(i)+"=>");
        //标记为已访问
        isVisited[i] = true;
        //将结点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()){
            //取出队列头结点下标
            u = (Integer) queue.removeFirst();
            //得到第一个邻结点的下标w
            w = getFirstNeighbor(u);
            while (w!=-1){
                //是否已经访问过
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w)+"=>");
                    //标记已经访问
                    isVisited[w] = true;
                    //入队
                    queue.addLast(w);
                }
                //以u为前驱点，找w后面的下一个邻接点
                w = getNextNeighbor(u,w);
            }
        }


    }

    //遍历所有节点，进行广度优先搜索
    public void bfs(){
        for (int i=0;i<getNumOfVertex();i++){
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    //图中常用方法
    //返回节点个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //显示图对应的矩阵
    public void showGraph(){
        for (int[] link:edges){
            System.err.println(Arrays.toString(link));
        }
    }

    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //返回节点i对应的数据0——>"A" 1->"B" 2->"c"
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //返回v1和v2的全职
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    //添加边
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

}
