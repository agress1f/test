package Dijkstra;

import java.util.Arrays;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex ={'A','B','C','D','E','F','G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;// 表示不可以连接
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};
        //创建 Graph对象
        Graph graph = new Graph(vertex, matrix);
        //测试, 看看图的邻接矩阵是否ok
        graph.showGraph();
        //测试dij
        graph.dsj(6);
    }
}

class Graph{
    private char[] vertex;
    private int[][] matrix;
    private VisitedVertex vv;//已经访问的顶点的集合

    //构造器
    public Graph(char[] vertex,int[][] matrix){
        this.matrix = matrix;
        this.vertex = vertex;
    }

    //显示图
    public void showGraph(){
        for (int[] link:matrix){
            System.out.println(Arrays.toString(link));
        }
    }

    //dijkstra
    /*
    * @param index表示出发顶点对应的下标
    *
    * */
    public void dsj(int index){
        VisitedVertex vv = new VisitedVertex(vertex.length,index);
        update(index);
    }

    //更新index下表顶点到周围顶点的距离和周围定点的前驱节点
    private void update(int index){
        int len = 0;
        for (int j=0;j<matrix[index].length;j++){
            // len 含义是 : 出发顶点到index顶点的距离 + 从index顶点到j顶点的距离的和
            len = vv.getDis(index) + matrix[index][j];
            // 如果j顶点没有被访问过，并且 len 小于出发顶点到j顶点的距离，就需要更新
            if(!vv.in(j) && len < vv.getDis(j)) {
                vv.updatePre(j, index); //更新j顶点的前驱为index顶点
                vv.updateDis(j, len); //更新出发顶点到j顶点的距离
            }
        }
    }
}
class VisitedVertex{
    public int[] already_arr;
    public int[] pre_visited;
    public int[] dis;
    //构造器
    /*
    * @param length表示顶点个数
    * @param index出发顶点对应的下标
    * */
    public VisitedVertex(int length,int index){
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        Arrays.fill(dis,65535);
        this.already_arr[index] = 1;//设置出发顶点被访问过
        this.dis[index] = 0;
    }
    /*
    * 功能：判断index顶点是否被访问过
    * @param index
    * @return 如果被访问过，就返回true，否则访问false
    * */
    public boolean in(int index){
        return already_arr[index]==1;
    }
    /*
     * 功能：更新出发顶点到index顶点的距离
     * @param index
     * @param len
     * */
    public void updateDis(int index,int len){
        dis[index] = len;
    }
/*
    * 功能：更新pre顶点的前驱节点为index节点
     * @param pre
    * @param index
* */
    public void updatePre(int pre,int index){
        pre_visited[pre] = index;
    }

    /*
    * 功能：返回出发顶点到index定点的距离
    * @param index
    *
    * */
    public int getDis(int index){
        return dis[index];
    }



}