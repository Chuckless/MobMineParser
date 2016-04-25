package mobmine.com.mobmineparser;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.util.ArrayList;

import mobmine.com.mobmineparser.Converter.fromXml;
import mobmine.com.mobmineparser.Converter.toXml;
import mobmine.com.mobmineparser.FileManager.Reader;
import mobmine.com.mobmineparser.FileManager.Writer;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reader r = new Reader();
        Writer w = new Writer();

        try {
            ArrayList<Point> points = r.splitFile("gpsvale.txt");
            String xml = toXml.toXml(points);
            w.writeFile("XmlTeste.xml", xml);
            points = fromXml.fromXml("XmlTeste.xml");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
