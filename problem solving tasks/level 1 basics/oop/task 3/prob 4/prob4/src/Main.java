//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your pum num :  ");
    int n = input.nextInt();

    PUM game = new PUM(n);
    game.print();

    input.close();
}
