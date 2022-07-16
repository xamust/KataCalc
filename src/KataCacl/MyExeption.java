package KataCacl;

public class MyExeption extends Exception {
    String myErr;
    MyExeption(String msg){
        this.myErr = msg;
        System.err.println(msg);
    }
    @Override
    public String getMessage() {
        return myErr;
    }
}
