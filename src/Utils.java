import java.io.*;

public class Utils {
    /**
     *
     * @param path
     * @return content from file
     * @throws IOException
     */
    public static String readContentFromFile(String path) {
        BufferedReader br = null;
        FileReader fr = null;
        String output = "";
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String current = null;
            output = br.readLine();
            while ((current = br.readLine()) != null) {
                output = output + "\n" + current;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    /**
     * write content to file
     * @param path
     */
    public static void writeContentToFile(String path){
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            String content = "write content to file\n";
            fw = new FileWriter(path);
            bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * write content to file without deleting existed content
     * @param path
     */
    public static void appendContentToFile(String path){
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            String content = "append content to file\n";
            fw = new FileWriter(path, true);
            bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param folderPath
     * @param fileName
     * @return file if not find folder
     * @return folder if exist in file
     *
     */
    public static File findFileByName(String folderPath, String fileName){
        File file = new File(folderPath);
        if (!file.exists()) {
            return null ;
        }
        if (file.isDirectory()){
            File[] folderList = file.listFiles() ;
            for (File folder : folderList){
                if (folder.isDirectory()){
                    file= findFileByName(folder.getAbsolutePath(), fileName);
                }
                if (folder.getName().endsWith(fileName)) {
                    System.out.println(folder.getAbsolutePath());
                    return folder ;
                }
            }
        }
        return file ;
    }
}


