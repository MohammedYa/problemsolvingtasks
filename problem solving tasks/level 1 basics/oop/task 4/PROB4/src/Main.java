//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner input = new Scanner(System.in);

    int a = input.nextInt();
    int b = input.nextInt();

    if (a + b > 0 && Math.abs(a - b) <= 1) {
        System.out.println("YES");
    } else {
        System.out.println("NO");
    }

    input.close();

}
