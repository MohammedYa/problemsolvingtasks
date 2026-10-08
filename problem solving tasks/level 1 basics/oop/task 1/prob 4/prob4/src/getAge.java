public class getAge {
    private int age;
    private  String results;
    getAge(int age){
        setAge(age);
        clulateAge(getAge());
    }

    private int getAge() {
        return age;
    }
    private void setAge(int age) {
        this.age = age;
    }

  public String   clulateAge(int age){
      int years = age / 365;
      int remainingDays = age % 365;

      int months = remainingDays / 30;
      int days = remainingDays % 30;
      this.results= "Years   "+years+  "   month  "+months +"   Days  "+days;
      System.out.print(this.results);
   return this.results ;
  }
}
