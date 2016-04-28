package mobmine.com.mobmineparser.Util;

import android.content.Context;
import android.util.Log;
import mobmine.com.mobmineparser.Converter.UTM2Deg;
import mobmine.com.mobmineparser.Domain.typeNames;
import mobmine.com.mobmineparser.Domain.Point;
import mobmine.com.mobmineparser.Singleton.Constants;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by lucas on 28/04/16.
 */
public final class InternalStorage {


    private InternalStorage() {

    }

    public static File openFile(String folderName, String fileName) {
        File file = new File(Constants.aplicationContext.getFilesDir() + "/"
                + folderName + "/" + fileName);

        return file;
    }

    public static void writeFile(Context context, String folderName, String fileName, String text) {
        try {

            File file = openFile(folderName, fileName);

            if (file.exists()) {
                file.delete();
            } else {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(text);
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Point> readGPSFile(Context context, String folderName, String fileName) {
        File file = openFile(folderName, fileName);

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            ArrayList<Point> points = new ArrayList<Point>();

            if (br != null) {

                br.mark(0);
                String parts[] = br.readLine().split(",");
                if (!parts[0].matches(".*[a-zA-Z]+.*") && br.markSupported()) {
                    br.reset();
                }

                while ((line = br.readLine()) != null) {
                    Point point = new Point();
                    parts = line.split(",");

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
                return points;
            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
