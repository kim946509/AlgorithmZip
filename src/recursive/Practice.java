package recursive;

public class Practice {

    private static void oneToN(int n){

        System.out.println(n);

        if(n-1>0) {
            oneToN(n - 1);
        }
    }

    private static int sumOneToN(int n){
        if(n==0)
            return 0;
        return n + sumOneToN(n-1);
    }

    private static void func(int a){
        if(a==0)return;
        func(a-1);
    }

    public static double func1 (int a, int b, int m){
        double val = 1;
        while(b!=0) {
            b--;
            val *= a;
        }
        return val % m;
    }
    public static void main(String[] args) {
        System.out.println(func1(6,100,5));
        System.out.println("done");
    }
}
