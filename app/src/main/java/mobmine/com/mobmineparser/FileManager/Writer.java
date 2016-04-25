package mobmine.com.mobmineparser.FileManager;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by lucas on 20/04/16.
 */
public class Writer {


    public File openFile(String fileName){
        File extSD = Environment.getExternalStorageDirectory();
        File file = new File(extSD.toString() + "/vale/" + fileName);

        return file;
    }

    private BufferedWriter openBuffer(String fileName){
        try {
            File file = openFile(fileName);
            if(file.exists()){
                file.delete();
            }else{
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            return bw;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void writeFile(String fileName, String text){
        BufferedWriter bw = openBuffer(fileName);
        try {
            bw.write(text);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
