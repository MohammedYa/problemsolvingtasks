public class PUM {
    private int n;

    public PUM(int n) {
        this.n = n;
    }

    public void print() {
        int num = 1;

        for (int i = 1; i <= n; i++) {
            System.out.println(num + " " + (num + 1) + " " + (num + 2) + " PUM");
            num += 4;
        }
    }
}
