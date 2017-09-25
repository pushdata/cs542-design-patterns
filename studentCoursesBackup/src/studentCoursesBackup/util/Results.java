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
        result.add(res);
    }

    public void writeToFile(String file1, String file2, String file3) {
        try {
            FileProcessor fp = new FileProcessor(file1, file2, file3, this.getResult());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
