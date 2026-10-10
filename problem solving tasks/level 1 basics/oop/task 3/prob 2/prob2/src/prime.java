public class prime {

    prime(int num ){
        setNum(num);
        printPreimeOrnot(getNum());
    }
    int num;

    private void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    private  void printPreimeOrnot(int num){
        boolean prime = true;

        if (num < 2) {
            prime = false;
        } else {
            for (int x = 2; x * x <= num; x++) {
                if (num % x == 0) {
                    prime = false;
                    break;
                }
            }
        }

        if (prime) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }

}
