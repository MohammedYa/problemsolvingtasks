//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
System.out.println("Enter your Frist Number : ");
Scanner inputone= new Scanner(System.in);
float fristNum=inputone.nextInt();

System.out.println("Enter your Sceand Number : ");
Scanner inputtwo= new Scanner(System.in);
float scendNum=inputtwo.nextInt();

System.out.println("Enter your Mathmatial opration  Number  ( 1 => diversion 2=> multiply  3=> Subtracting 4 => adding : ");
Scanner input= new Scanner(System.in);
int operation=input.nextInt();

if(operation==1||operation==2||operation==3||operation==4){
    operation Fristopration=new operation(operation,fristNum,scendNum);

}
else{
    System.out.println("Your Operation is not Exist  Try agin .... : ");
}

}
