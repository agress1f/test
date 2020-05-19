package datastructure;

public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(2,'A','B','C');
    }

    //汉诺塔移动方案
    //使用分治
    public static void hanoiTower(int num,char a,char b,char c){
        if (num==1){
            System.out.println("第1个盘 "+a+"->"+c);
        }else {
            //如果有>=n情况，我们总是可以看作是两个盘1.最下边2.上面所有
            //1.首先把最上面的所有盘A->B,移动过程中会使用到C
            hanoiTower(num-1,a,c,b);
            //2.把最下面的盘A->C
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            //3.把B塔的所有盘从B->C,移动过程中使用到a塔
            hanoiTower(num-1,b,a,c);
        }
    }
}
