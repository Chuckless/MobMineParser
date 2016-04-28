package mobmine.com.mobmineparser.Util;

import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import mobmine.com.mobmineparser.Domain.Point;
import mobmine.com.mobmineparser.Singleton.Constants;

/**
 * Created by lucas on 20/04/16.
 */
public class fromXml {

    public fromXml(){}

    public static ArrayList<Point> fromXml(String fileName){
        ArrayList<Point> points = new ArrayList<>();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(InternalStorage.openFile(Constants.XMLFOLDERNAME, fileName));
            doc.getDocumentElement().normalize();

            Log.d("Xml", "Root element:" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("ponto");
            Log.d("Xml", nList.toString());
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                Log.d("Xml", "Current Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    Log.d("Xml", "id: " + element.getAttribute("id"));
                    Log.d("Xml", "X: " + element.getAttribute("X"));
                    Log.d("Xml", "Y: " + element.getAttribute("Y"));
                    Log.d("Xml", "Z: " + element.getAttribute("Z"));
                    Log.d("Xml", "Type: " + element.getParentNode().getNodeName());

                    Point point = new Point();
                    point.setId(Integer.parseInt(element.getAttribute("id")));
                    point.setXcord(Float.parseFloat(element.getAttribute("X")));
                    point.setYcord(Float.parseFloat(element.getAttribute("Y")));
                    point.setZcord(Float.parseFloat(element.getAttribute("Z")));
                    point.setType(element.getParentNode().getNodeName());

                    points.add(point);
                }

            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return points;
    }

}
