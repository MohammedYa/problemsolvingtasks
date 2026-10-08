public class operation {
    private float num1,num2;
    private  int oprator;
    private int result;
   public operation(int oprator ,float num1,float num2){
        setNum1(num1);
        setNum2(num2);
        setOprator(oprator);
        printResult(getNum1(),getNum2(),getOprator());
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }
    public void setNum2(float num2) {
        this.num2 = num2;
    }
    public void setOprator(int oprator) {
        this.oprator = oprator;
    }

    public float getNum1() {
        return num1;
    }
    public float getNum2() {
        return num2;
    }
    public char getOprator() {
        switch (this.oprator) {
            case 1:
                return '/';

            case 2:
                return '*';

            case 3:
                return '-';

            default:

                return '+';


        }
    }

    private int operationOfNumber(float num1, float num2, char operator) {

        switch (operator) {
            case '+':
                return (int)(num1 + num2);

            case '-':
                return (int)(num1 - num2);

            case '*':
                return (int)(num1 * num2);

            default:

                return (int)(num1 / num2);


        }
    }



     private  void  printResult(float num1, float num2, char operator){
       System.out.print(" the result of operation is =  "+operationOfNumber(num1,num2,operator));
     }
}
