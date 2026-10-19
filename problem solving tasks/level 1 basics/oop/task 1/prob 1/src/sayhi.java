public class sayhi {


    public  sayhi(String name){
        getmassage(name);
    }
    private String name;
    private  String  getmassage(){
        return name;
    }
    public void  getmassage(String name){
        this.name=name;
        if(this.name==""){
            System.out.print("Name Is not valid");
        }
        else {
            System.out.print("Hello, "+this.name);
        }
    }



}
