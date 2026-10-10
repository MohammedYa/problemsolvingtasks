public class Pramied {
    Pramied(int num){
        setNum(num);
        printPramid(getNum());
    }
    int num;

    private void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
  private void  printPramid(int num){
        for(int i=1;i<=num;i++){
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
        }
    }
}
