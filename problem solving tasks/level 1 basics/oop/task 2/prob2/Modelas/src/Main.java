//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner input =new Scanner(System.in);
    System.out.print("Enter the MoMo Num : ");
    int moMoNum=input.nextInt();
    System.out.print("Enter the MeMo Num : ");
    int meMoNum=input.nextInt();
    System.out.print("Enter the Num Will Divid Them : ");
    int dividNum=input.nextInt();
    Game FristGame=new Game(moMoNum,meMoNum,dividNum);
}
