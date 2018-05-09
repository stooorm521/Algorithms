package priorityQueue;

public class Test {
    public static int test(int a) {
        if (a == 1) return a;
        else
            return test(a - 1) + a;
    }

    // fibonacchi一种跟高效的递归方式, 线性递归
    static int fib_2(int n) {
        return fib_rec(1, 1, n);
    }

    static int fib_rec(int a, int b, int n) {
        if (n <= 1) return 1;
        else return a + fib_rec(b, a + b, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(fib_2(9));
    }

    //尾递归 最后一步是对自身一摸一样的调用(仅仅参数不一样，没有a+ )
    int fib_4(int n) {
        return fib_iter(1, 1, n);
    }

    int fib_iter(int a, int b, int n) {
        if (n == 0) {
            return a;
        } else return fib_iter(b, a + b, n - 1);
    }

}
