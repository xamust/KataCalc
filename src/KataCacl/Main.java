package KataCacl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static String result;

    public static void main(String[] args) throws IOException, MyExeption {
        System.out.println("Calculator is started...(print exit to quit)");
        while (true){
            System.out.println(calc(Reader()));
        }
    }
    public static String calc(String input) throws MyExeption{
        CheckData ch = new CheckData(input);
        switch (ch.GetType()){
            case "roman":
                CalcRoman cR = new CalcRoman();
                cR.setInputData(ch.nums);
                cR.setOperation(ch.oper);
                return cR.getResult();
            case "arabic":
                CalcArabic cA = new CalcArabic();
                cA.setInputData(ch.nums);
                cA.setOperation(ch.oper);
                return cA.getResult();
            default:
                throw new MyExeption("Incorrect string!");
        }
    }
    public static String Reader() throws IOException {
         result = reader.readLine();
        switch (result){
            case "exit":
                System.out.println("Exit from calculator...");
                System.exit(0);
            default:
                return result;
        }
    }
}
