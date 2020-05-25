package kruskal;

import javax.print.attribute.standard.MediaPrintableArea;
import java.util.Arrays;

public class KruskalCase {
    private int edgeNum;
    private char[] vertexs;//顶点数组
    private int[][] matrix;
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        //创建KruskalCase 对象实例
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        //输出构建的
        kruskalCase.print();
        kruskalCase.kruskal();
//        EData[] edges = kruskalCase.getEdges();
//        System.out.println("排序前：\n"+Arrays.toString(edges));
//        kruskalCase.sortEdges(edges);
//        System.out.println("排序后：\n"+Arrays.toString(edges));
    }

    //构造器
    public KruskalCase(char[] vertexs,int[][] matrix){
        int vlen = vertexs.length;
        //初始化顶点,复制拷贝的方式
        this.vertexs = new char[vlen];
        for (int i=0;i<vertexs.length;i++){
            this.vertexs[i] = vertexs[i];
        }
        //初始化边
        this.matrix = new int[vlen][vlen];
        for (int i=0;i<vlen;i++){
            for (int j=0;j<vlen;j++){
                this.matrix[i][j] = matrix[i][j];
            }
        }

        //统计边
        for (int i=0;i<vlen;i++){
            for (int j=i+1;j<vlen;j++){
                if (this.matrix[i][j]!=INF){
                    edgeNum++;
                }
            }
        }

    }
    public void kruskal(){
        int index = 0;//最后结果数组的索引
        int[] ends = new int[edgeNum];//用于保存“已有最小生成树”中的每个顶点在最小生成树中的终点
        //创建结果数组，保存最后的最小生成树
        EData[] rets = new EData[edgeNum];
        //获取图中所有的边的集合
        EData[] edges = getEdges();
        System.out.println("图的边的集合="+Arrays.toString(edges)+"共"+edges.length);
        //按照权值大小排序（从小到大）
        sortEdges(edges);
        //遍历edges数组，将边添加到最小生成树中时，判断是否形成回路，如果没有，就加入rets，否则不能加入
        for (int i=0;i<edgeNum;i++){
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);
            //获取p1这个顶点在已有最小生成树中的终点
            int m = getEnd(ends,p1);
            int n = getEnd(ends,p2);
            if (m!=n){
                ends[m] = n;//设置m在已有最小生成树
                rets[index++] = edges[i];
            }

        }
        //统计并打印“最小生成树”,输出res
        System.out.println("最小生成树为：");
        for (int i=0;i<index;i++){
            System.out.println(rets[i]);
        }

    }


    public void print(){
        System.out.println("邻接矩阵：\n");
        for (int i=0;i<vertexs.length;i++){
            for (int j=0;j<vertexs.length;j++){
                System.out.printf("%12d",matrix[i][j]);
            }
            System.out.println();//换行处理
        }
    }

    //对边进行排序，冒泡排序
    private void sortEdges(EData[] edges) {
        for(int i = 0; i < edges.length - 1; i++) {
            for(int j = 0; j < edges.length - 1 - i; j++) {
                if(edges[j].weight > edges[j+1].weight) {//交换
                    EData tmp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = tmp;
                }
            }
        }
//        return edges;
    }

    //找到ch顶点对应的下标
    private int getPosition(char ch){
        for (int i=0;i<vertexs.length;i++){
            if (vertexs[i] == ch){
                return i;
            }
        }
        return -1;
    }

    //产生边的集合
    private EData[] getEdges(){
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i=0;i<vertexs.length;i++){
            for (int j=i+1;j<vertexs.length;j++){
                if (matrix[i][j]!=INF){
                    edges[index++] = new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }
/*
* 获取下表为i的顶点的终点
* @param ends ： 数组就是记录了各个顶点对应的终点是哪个,ends 数组是在遍历过程中，逐步形成
* @param i : 表示传入的顶点对应的下标
* @return 返回的就是 下标为i的这个顶点对应的终点的下标, 一会回头还有来理解
* */
    private int getEnd(int[] ends,int i){
        while (ends[i]!=0){
            i = ends[i];
        }
        return i;
    }


}



//创建一个类EData,它的对象实例就表示一条边
class EData{
    char start;//边的一点
    char end;//边的另外一个点
    int weight;//边的权值
    public EData(char start,char end,int weight){
        this.end = end;
        this.start = start;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
