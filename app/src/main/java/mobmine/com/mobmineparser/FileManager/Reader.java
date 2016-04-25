package mobmine.com.mobmineparser.FileManager;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import mobmine.com.mobmineparser.Converter.UTM2Deg;
import mobmine.com.mobmineparser.Converter.typeNames;
import mobmine.com.mobmineparser.Point;

/**
 * Created by lucas on 19/04/16.
 */
public class Reader {

    public Reader() {
    }

    public File openFile(String fileName){
        File extSD = Environment.getExternalStorageDirectory();
        File file = new File(extSD.toString() + "/vale/" + fileName);

        return file;
    }

    public BufferedReader openBuffer(String fileName){
        File file = openFile(fileName);

        try {

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            return br;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Point> splitFile(String fileName) throws IOException {
        BufferedReader br = openBuffer(fileName);
        String line;
        ArrayList<Point> points = new ArrayList<Point>();

        if(br != null) {

            br.mark(0);
            if(!checkHeader(br.readLine())){
                br.reset();
            }

            while ((line = br.readLine()) != null) {
                Point point = new Point();
                String[] parts = line.split(",");

                point.setId(Integer.parseInt(parts[0]));
                point.setXcord(Float.parseFloat(parts[1]));
                point.setYcord(Float.parseFloat(parts[2]));
                point.setZcord(Float.parseFloat(parts[3]));
                point.setType(typeNames.findTypeName(parts[4]));

                String UTM = "23 K " + parts[1] + " " + parts[2];

                UTM2Deg pos = new UTM2Deg(UTM);
                Log.d("file", point.toString());
                //Log.d("file", String.valueOf(pos.latitude) + ", " + String.valueOf(pos.longitude));
                points.add(point);

            }
        }

        return points;
    }

    private boolean checkHeader(String firstLine) {
        String parts[] = firstLine.split(",");
        return(parts[0].matches(".*[a-zA-Z]+.*"));
    }


}
