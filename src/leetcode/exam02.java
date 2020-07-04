package leetcode;

import java.util.*;


public class exam02 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int T =sc.nextInt();
        while(T-->0){
            int n=sc.nextInt();
            Set<F> ts=new TreeSet<F>(new SORT());
            //  F  f[] =new F[n];
            for(int i=0; i<n; i++){

                int a=sc.nextInt();
                int b=sc.nextInt();
                F f =new F(a,b);
                ts.add(f);
            }
            F  ff[] = new F[n];
            Iterator<F> it=ts.iterator();
            int e=-1;
            while(it.hasNext()){
                ff[++e]=it.next();
            }
            int count=ff[0].b-ff[0].a;
            int nn=ff[0].b;
            int mm;
            for(int i=0;i<n;i++){
                mm=ff[i].a;
                if(nn<=23&&nn>=8&&mm>=8&&mm<=23&&nn<=mm){
                    nn=ff[i].b;
                    count = count+ff[i].b-ff[i].a;
                }
            }
            System.out.println(count);

        }
    }
}
class SORT implements Comparator<F> {

    @Override
    public int compare(F o1, F o2) {
        if(o1.b==o2.b)
            return -1;
        return (o1.b-o2.b);
    }
}
class  F{
    int a,b;
    F(int a,int b){
        this.a=a;
        this.b=b;
    }
    F(){}
}

