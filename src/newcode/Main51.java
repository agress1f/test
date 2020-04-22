package newcode;

public class Main51 {
    public static int[] multiply(int[] A) {
        int[] f1 = new int[A.length]; // 0到i-1的乘积
        int[] f2 = new int[A.length]; // i+1到n-1的乘积

        int ans1 = 1; // 0-(i-1)的乘积
        int ans2 = 1; // (i+1)-n-1的乘积
        int[] B = new int[A.length];
        for (int i = 0, j = A.length - 1; i < A.length; i++, j--) {
            f1[i] = ans1;
            ans1 *= A[i];

            f2[j] = ans2;
            ans2 *= A[j];
        }

        for (int i = 0; i < A.length; i++) {
            B[i] = f1[i] * f2[i];
        }
        return B;
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,2,3,4,5};
        int b[]  =  multiply(a);
        for (int i =0;i<b.length;i++){
            System.out.println(b[i]);
        }

    }
}
