package studentCoursesBackup.util;

import java.io.IOException;
import java.util.ArrayList;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    private ArrayList<String> result = new ArrayList<>();

    public Results() {

    }

    public ArrayList<String> getResult() {
        return result;
    }

    public void setResult(String res) {
        String temp = res.toString().replace("[", "").replace("]", "");
        result.add(temp + "\n");
    }

    public void writeToFile(String file1) {
        try {
            FileProcessor fp = new FileProcessor(file1, this.getResult());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
