package mobmine.com.mobmineparser.Util;

import android.util.Log;

import java.util.ArrayList;

import mobmine.com.mobmineparser.Domain.Point;
import mobmine.com.mobmineparser.Domain.typeNames;

/**
 * Created by lucas on 20/04/16.
 */
public class toXml {

    static int id = 0;

    public static String toXml(ArrayList<Point> points){
        String xml = "";
        String temp = "";
        xml = xml + "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
        xml = xml + "<project name=\"" + "MobMine" + "\">\n"
                + "\t<malha " + "id=\""+ id +"\">\n";

        for(typeNames t : typeNames.values()){
            temp = temp + " \t\t<" + t.toString() + ">\n";
            for(Point point : points){
                if(t.toString().equals(point.getType())){
                    temp = temp + "\t\t\t<ponto id=\"" + point.getId() + "\" X=\"" + point.getXcord() + "\" Y=\"" + point.getYcord() + "\" Z=\"" + point.getZcord() + "\"/>\n";
                }
            }
            Log.d("MobMine", t.toString());
            temp = temp + "\t\t</" + t.toString() + ">\n";
            xml = xml + temp;
            temp = "";
        }

        xml = xml + "\t</malha>\n";
        xml = xml + "</project>";

        id++;

        Log.d("MobMine", xml);
        return xml;
    }
}
