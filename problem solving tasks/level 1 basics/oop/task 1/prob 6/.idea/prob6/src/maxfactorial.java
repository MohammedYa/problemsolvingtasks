public class maxfactorial {
    public  maxfactorial(int num1,int num2 ,int num3 ,int num4){
        setNum1(num1);
        setNum2(num2);
        setNum3(num3);
        setNum4(num4);

        comparePowers(getNum1(),getNum2(),getNum3(),getNum4());
    }

    private int num1,num2,num3,num4;

    private void setNum1(int num1) {
        this.num1 = num1;
    }
    private void setNum2(int num2) {
        this.num2 = num2;
    }

    private void setNum3(int num3){
        this.num3=num3;
    }
    private void setNum4(int num4) {
        this.num4 = num4;
    }

    public int getNum1() {
        return num1;
    }
    public int getNum2() {
        return num2;
    }
    public int getNum3() {
        return num3;
    }
    public int getNum4() {
        return num4;
    }

    private void comparePowers(int num1,int num2,int num3,int num4) {
        System.out.print(getNum1()+""+getNum2()+""+getNum3()+""+getNum4());
       double fact1=Math.pow(num1, num2);
       double fact2=Math.pow(num3, num4);
        if (fact1>fact2 ) {

            System.out.print("Yes");

        }
        else if (fact1<fact2) {
            System.out.print("No");

        }
        else {
            System.out.print("Eqels");

        }
    }
}
