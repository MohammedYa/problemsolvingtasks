import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
  Scanner input = new Scanner(System.in);

  System.out.print("Enter Frist Num :");
  int num1 = input.nextInt();

  System.out.print("Enter sceand Num :");
  int num2 = input.nextInt();

  System.out.print("Enter Third Num :");
  int num3 = input.nextInt();

  System.out.print("Enter Fourth Num :");
  int num4 = input.nextInt();

  System.out.print(num1 +" "+num2+""+num3+""+num4);

  maxfactorial fristcase=new maxfactorial(num1,num2,num3,num4);
}
