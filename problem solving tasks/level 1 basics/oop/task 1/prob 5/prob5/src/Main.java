import java.util.Scanner;

void main() {
    Scanner inputStartFristInterval=new Scanner(System.in);
    System.out.print("Enter the start of frist interval :");
    int startFristInterval=inputStartFristInterval.nextInt();

    Scanner inputEndFristInterval=new Scanner(System.in);
    System.out.print("Enter the End of frist interval :");
    int endFristInterval=inputEndFristInterval.nextInt();

    Scanner inputStartSecendInterval=new Scanner(System.in);
    System.out.print("Enter the start of Sceand interval :");
    int startSecendInterval=inputStartSecendInterval.nextInt();

    Scanner inputEndSecendInterval=new Scanner(System.in);
    System.out.print("Enter the End of Sceand interval :");
    int endsecendInterval=inputEndSecendInterval.nextInt();


    int start=Math.max(startFristInterval,startSecendInterval) ;
    int end=Math.min(endFristInterval,endsecendInterval) ;
    if(start<=end){
        System.out.println(start + " " + end);

    }
    else{
        System.out.println("-1");

    }

}
