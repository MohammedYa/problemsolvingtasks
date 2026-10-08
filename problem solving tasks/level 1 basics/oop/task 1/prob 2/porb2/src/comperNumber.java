public class comperNumber {
    public comperNumber(int num1,int num2, int num3){
        setNum1( num1);
        setNum2( num2);
        setNum3( num3);

        printMaxAndMinNumber(getMaxNum(getNum1(),getNum2( ),getNum3( )),getMinNum(getNum1(),getNum2( ),getNum3( )));
    }

    private  int num1,num2,num3,maxNum,MinNum;

    private void setNum1(int num1) {
        this.num1 = num1;
    }
    private void setNum2(int num2) {
        this.num2 = num2;
    }
    private void setNum3(int num3) {
        this.num3 = num3;
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



    private int getMaxNum( int num1,  int num2 , int num3){
        if(num1>num2){
            if(num1>num3){
                this.maxNum=num1;
                return  this.maxNum;
            }
            else{
                this.maxNum=num3;
                return  this.maxNum;
            }
        }
        else if (num2>num3) {
           this.maxNum=num2;
            return  this.maxNum;
        }
        else {
            this.maxNum=num3;
            return  this.maxNum;
        }
   }
    private int getMinNum( int num1,  int num2 , int num3){
        if(num1<num2){
            if(num1<num3){
                this.MinNum=num1;
                return this.MinNum;

            }
            else{
                this.MinNum=num3;
                return this.MinNum;

            }
        }
        else if (num2<num3) {
            this.MinNum=num2;
            return this.MinNum;

        }
        else {
            this.MinNum=num3;
            return this.MinNum;
        }
    }


    private void  printMaxAndMinNumber(int max,int min){
        System.out.print("Max Number is :"+max +"   Min Number is "+min);
    }
}
