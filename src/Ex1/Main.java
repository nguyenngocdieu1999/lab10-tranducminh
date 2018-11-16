package Ex1;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args)   {
        Analysis analysis = new Analysis();
        File file = new File("src/Utils.java");
        List<String> list = analysis.getAllFunctions(file);
        for(String fuction : list){
            System.out.println(fuction);
        }

        System.out.println(analysis.findFunctionByName("findFileByName(String,String)"));
    }
}
