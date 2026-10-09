public class Game {
  public   Game(int momoNum,int memoNum,int divideNum){
      setDivideNum(divideNum);
      setMemoNum(memoNum);
      setMomoNum(momoNum);
      PrintResultOfGame(getMomoNum(),getMemoNum(),getDivideNum());

    }
    private int  momoNum;
    private int  memoNum;
    private int  divideNum;

    public int getMemoNum() {
        return memoNum;
    }
    public int getMomoNum() {
        return momoNum;
    }
    public int getDivideNum() {
        return divideNum;
    }

    private void setDivideNum(int divideNum) {
        this.divideNum = divideNum;
    }
    private void setMemoNum(int memoNum) {
        this.memoNum = memoNum;
    }
    private void setMomoNum(int momoNum) {
        this.momoNum = momoNum;
    }

    private void  PrintResultOfGame(int momoNum,int memoNum,int divideNum){
        if(momoNum%divideNum==0&&memoNum%divideNum==0){
            System.out.print("Both win ...");
        } else if (momoNum%divideNum==0&&memoNum%divideNum!=0) {
            System.out.print("MoMo win ...");
        } else if (momoNum%divideNum!=0&&memoNum%divideNum==0) {
            System.out.print("MeMo win ...");
        }
        else{
            System.out.print("Mised Point   ...");

        }
    }
}
