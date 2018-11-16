package Ex1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
    private List<String> allFunctions = new ArrayList();
    /**
     *
     * @param path
     * @return list contant all function in file
     */
    List<String> getAllFunctions(File path){
        BufferedReader br = null;
        FileReader fr = null;
        String source = "";
        int bracketStart = 1, bracketEnd = 0;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String current = null;
            boolean run = true;
            while ((current = br.readLine()) != null) {
                if((current.contains("/**"))){
                    while (current.endsWith("*/")){
                        current = br.readLine();
                    }
                }
                else if((current.contains("/*"))){
                    while (current.endsWith("*/")){
                        current = br.readLine();
                    }
                }
                else if((current.contains("//"))){
                    current = br.readLine();
                }
                else if((current.indexOf("public static")) != -1){
                    run = true;
                    source = current;

                    while (run){
                        current = br.readLine();
                        if((current.indexOf("{")) != -1)
                            bracketStart++;

                        if((current.indexOf("}")) != -1)
                            bracketEnd++;

                        source = source + "\n" + current;

                        if(bracketStart == bracketEnd){
                            bracketStart = 1;
                            bracketEnd = 0;
                            allFunctions.add(source);
                            source = "";
                            run = false;
                        }
                    }
                }
                source = source + "\n" + current;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return allFunctions;
    }

    /**
     *
     * @param name
     * @return sourcode of fucntion which finding
     */
    public String findFunctionByName(String name){
        File file = new File("src/Utils.java");
        List<String> listFunctions = getAllFunctions(file);
        List<String> list = new ArrayList<>();

        String nameFunc = name.substring(0, name.indexOf("("));

        for(String str : listFunctions){
            if((str.indexOf(nameFunc)) != -1){
                list.add(str);
            }
        }

        for(String str : list){
            int index = -1;
            String function = str.substring(str.indexOf(nameFunc), str.indexOf("{"));
            String[] arr = (name.substring(name.indexOf("(") + 1, name.indexOf(")"))).split(",");

            for(int i = 0; i < arr.length; i++){
                index = function.indexOf(arr[i], index);
            }
            if(index != -1)
                return str;
        }
        return null;
    }
}
