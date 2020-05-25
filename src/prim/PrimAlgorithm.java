package prim;

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};

        MGraph graph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(graph,verxs,data,weight);
        minTree.showGraph(graph);
        minTree.prim(graph,1);
    }
}

class MinTree{
    //创建图的邻接矩阵
    /**
     *
     * @param graph 图对象
     * @param verxs 图对应的顶点个数
     * @param data 图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph,int verxs,char data[],int[][] weight){
        int i,j;
        for (i=0;i<verxs;i++){
            graph.data[i] = data[i];
            for (j=0;j<verxs;j++){
                graph.weight[i][j] = weight[i][j];
            }
        }
    }


    public void showGraph(MGraph graph){
        for (int[] link:graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }

    //编写prim算法，得到最小生成树
    /**
     *
     * @param graph 图
     * @param v 表示从图的第几个顶点开始生成'A'->0 'B'->1...
     */

    public void prim(MGraph graph,int v){
        int visited[] = new int[graph.verxs];
        visited[v] = 1;
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        //用来计数n-1条边
        for (int k=1;k<graph.verxs;k++){

            for (int i=0;i<graph.verxs;i++){
                for (int j=0;j<graph.verxs;j++){
                    if (visited[i]==1&&visited[j]==0&&graph.weight[i][j]<minWeight){
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+">权值："+minWeight);
            visited[h2] = 1;
            minWeight = 10000;
        }
    }

}

class MGraph{
    int verxs;//节点个数
    char[] data;//存放节点数据
    int[][] weight;//邻接矩阵

    public MGraph(int verxs){
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }

}
