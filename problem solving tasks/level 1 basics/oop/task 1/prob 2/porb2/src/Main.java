//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    System.out.print("Enter Num 1: ");
    Scanner input = new Scanner(System.in);
     int Num1=input.nextInt();

    System.out.print("Enter Num 2: ");
    Scanner input2 = new Scanner(System.in);
    int Num2=input2.nextInt();

    System.out.print("Enter Num 3: ");
    Scanner input3 = new Scanner(System.in);
    int Num3=input3.nextInt();


    comperNumber compare=new comperNumber(Num1,Num2,Num3);
}
