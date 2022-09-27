public class Arithmetics {

    private int a;
    private int b;

    public void initiation(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int sum() {
        return a + b;
    }

    public int multiplication() {
        return a * b;
    }

    public int max() {
        return Math.max(a, b);
    }

    public int min() {
        return Math.min(a, b);
    }
}
