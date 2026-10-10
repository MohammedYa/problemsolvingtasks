public class printer {
    printer(int num){
        setNum(num);
        print_privios_num(getNum());
    }
    int num;

    public int getNum() {
        return num;
    }

    private void setNum(int num) {
        this.num = num;
    }
    private  void print_privios_num(int num){
        System.out.print("The previous Number are : ");
        for(int x=0;x<=num;x++){
            System.out.print("   "+x);
        }
    }
}
